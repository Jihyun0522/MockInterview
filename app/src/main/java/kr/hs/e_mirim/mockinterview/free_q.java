package kr.hs.e_mirim.mockinterview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class free_q extends AppCompatActivity {
    private Button camera;
   // private Button next;
    private Button end;
    char[] qChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_q);

        Button home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_menu.class);
                startActivity(intent);
            }
        });

        final Intent intent = getIntent();
        final String Q = intent.getStringExtra("Q");
        final TextView question=findViewById(R.id.question);

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

        if(Q == null) {
            Toast.makeText(getApplicationContext(), "질문이 선택되지 않았습니다.", Toast.LENGTH_LONG).show();
        }
        qChar = Q.toCharArray();
        question.setText(qChar, 0, qChar.length);

        /*next=findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setVisibility(View.GONE);
            }
        });*/

        end=findViewById(R.id.btn_end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), free.class);
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
