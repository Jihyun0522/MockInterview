package kr.hs.e_mirim.mockinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class interviewExplan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);

        Button home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_menu.class);
                startActivity(intent);
            }
        });

        TextView title=findViewById(R.id.text_title);
        TextView explan=findViewById(R.id.text_explan);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        switch (name){
            case "newStudent":
                title.setText("신입생 면접");
                explan.setText("이 면접은 신입생 면접입니다.");
                break;

            case "club":
                title.setText("동아리 면접");
                explan.setText("이 면접은 동아리 면접입니다.");
                break;

            case "company":
                title.setText("회사 면접");
                explan.setText("이 면접은 회사 면접입니다.");
                break;
        }

        Button start=findViewById(R.id.interview_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), mock_q.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
