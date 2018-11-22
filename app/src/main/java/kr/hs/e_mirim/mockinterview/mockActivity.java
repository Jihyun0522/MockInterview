package kr.hs.e_mirim.mockinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock);

        Button home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_menu.class);
                startActivity(intent);
            }
        });

        Button newStudent=findViewById(R.id.newStudent);
        Button club=findViewById(R.id.club);
        Button company=findViewById(R.id.company);

        newStudent.setOnClickListener(onClickListener);
        club.setOnClickListener(onClickListener);
        company.setOnClickListener(onClickListener);
    }

    Button.OnClickListener onClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            switch (view.getId()) {
                case R.id.newStudent:
                    intent=new Intent(getApplicationContext(), interviewExplan.class);
                    intent.putExtra("name", "newStudent");
                    startActivity(intent);
                    break ;
                case R.id.club:
                    intent=new Intent(getApplicationContext(), interviewExplan.class);
                    intent.putExtra("name", "club");
                    startActivity(intent);
                    break ;
                case R.id.company:
                    intent=new Intent(getApplicationContext(), interviewExplan.class);
                    intent.putExtra("name", "company");
                    startActivity(intent);
                    break ;
            }
        }
    } ;

}
