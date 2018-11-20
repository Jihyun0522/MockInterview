package kr.hs.e_mirim.mockinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class free extends AppCompatActivity {
    ArrayList<String> Items;
    ArrayAdapter<String> adapter;
    ListView listView;
    Button btnAdd;
    EditText addText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        Button home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_menu.class);
                startActivity(intent);
            }
        });

       Items = new ArrayList<String>();
       Items.add("좌우명이 뭔가요?");
       Items.add("마찰이 생긴다면 어떻게 대처할 건가요?");

       adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Items);
       listView = (ListView) findViewById(R.id.listview);
       listView.setAdapter(adapter);
       listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

       addText = (EditText) findViewById(R.id.addText);
       btnAdd = (Button) findViewById(R.id.add);

       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String text = addText.getText().toString();
               if(text.length() != 0){
                   Items.add(text);
                   addText.setText("");
                   adapter.notifyDataSetChanged();
               }
           }
       });

    }
}
