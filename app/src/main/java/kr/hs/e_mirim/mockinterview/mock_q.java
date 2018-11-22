package kr.hs.e_mirim.mockinterview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class mock_q extends AppCompatActivity {
    private Button camera;
    private Button next;
    private Button end;

    private String[] newStudent = {"30초 정도의 간단한 소개", "최근에 읽은 IT 기사는?", "자신은 좌우명은?", "개발자/디자이너로서 디자이너/개발자와 트러블이 생긴다면?", "지금 생각나는 사자성어는?",
                    "좋아하는 책은? 그 책과 IT와의 관련은?", "기억에 남는 교내외 수상은?", "사용하는 앱의 개발자가 된다면 추가하고 싶은 기능은?", "색맹에게 색 설명하기(색 임의 지정)", "친구란?",
                    "내년 크리스마스는 무슨 요일?", "무인도에 가져갈 3가지는?", "친구와 사과하는 방법은?", "단어 3개만으로 문장만들기", "학교에 입학해서 배우고 싶은 것은?", "목표 또는 좌우명은?",
                    "자신의 장점과 단점은?", "동물 중 어떤 동물이 되고 싶나요?"};
    private String[] club = {"30초 정도의 간단한 소개", "선배랑 트러블이 생긴다면?", "동아리에 지원하게 된 결정적인 이유", "이 공간에서 마음에 들지 않는 것은?", "우리 동아리 이름을 바꾸고 싶다면?",
                    "합격을 한다면 어떤 공모전에 나가고 싶나요?", "어떤 작품을 만들 것인가요?", "자신의 장점과 단점은?", "동아리에 들어오게 된 동기는?", "자신을 음식으로 표현하자면?",
                    "동아리와 학교 이벤트가 겹친다면?"};
    private String[] company = {"30초 정도의 간단한 소개"};

    String point[];

    Random rnd = new Random();
    int random = 0;
    int random2 = 0;
    int count = 0;
    char[] qChar;
    int i = 0;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_q);

        Button home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_menu.class);
                startActivity(intent);
            }
        });

        TextView title=findViewById(R.id.text_title);
        final TextView question=findViewById(R.id.question);
        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        switch (name){
            case "newStudent":
                title.setText("신입생 면접");
                random  = rnd.nextInt(newStudent.length);
                qChar = newStudent[random].toCharArray();
                question.setText(qChar, 0, qChar.length);
                i++;
                break;

            case "club":
                title.setText("동아리 면접");
                random  = rnd.nextInt(club.length);
                qChar = club[random].toCharArray();
                question.setText(qChar, 0, qChar.length);
                i++;
                break;

            case "company":
                title.setText("회사 면접");
                random  = rnd.nextInt(company.length);
                qChar = company[random].toCharArray();
                question.setText(qChar, 0, qChar.length);
                i++;
                break;
        }

        camera=(Button)findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isExistsCameraApplication()){
                    Intent cameraApp = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraApp, 10000);
                }
            }
        });

        next=findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                switch (name){
                    case "newStudent":
                        random2 = rnd.nextInt(newStudent.length);
                        if(random2 == random) if(random2++ > newStudent.length) random2 = 0;
                        qChar = newStudent[random2].toCharArray();
                        question.setText(qChar, 0, qChar.length);
                        random = random2;
                        break;

                    case "club":
                        random2 = rnd.nextInt(club.length);
                        if(random2 == random) if(random2++ > newStudent.length) random2 = 0;
                        qChar = club[random2].toCharArray();
                        question.setText(qChar, 0, qChar.length);
                        random = random2;
                        break;

                    case "company":
                        random2 = rnd.nextInt(company.length);
                        if(random2 == random) if(random2++ > newStudent.length) random2 = 0;
                        qChar = company[random2].toCharArray();
                        question.setText(qChar, 0, qChar.length);
                        random = random2;
                        break;
                    }

                if(i == 5) next.setVisibility(View.GONE);
                }
            });

        end=findViewById(R.id.btn_end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), mockActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean isExistsCameraApplication(){
        PackageManager packageManager = getPackageManager();

        Intent cameraApp = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        List<ResolveInfo> cameraApps = packageManager.queryIntentActivities(cameraApp, PackageManager.MATCH_DEFAULT_ONLY);

        return cameraApps.size() > 0;
    }

}
