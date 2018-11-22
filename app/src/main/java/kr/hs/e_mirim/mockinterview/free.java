package kr.hs.e_mirim.mockinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class free extends AppCompatActivity {
    ArrayList<String> Items;
    ArrayAdapter<String> adapter;
    ListView listView;
    Button btnAdd, start;
    EditText addText;
    //SparseBooleanArray booleans = listView.getCheckedItemPositions();

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

       //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Items);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, Items);
        listView = (ListView) findViewById(R.id.listview);
       listView.setAdapter(adapter);
       listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

       /*final String[] free_Q = new String[];
       final int j = 0;
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String select = (String) adapterView.getItemAtPosition(i);
               free_Q[j] = select;
               j++;
           }
       });*/

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

       start = (Button) findViewById(R.id.start);
       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SparseBooleanArray booleans = listView.getCheckedItemPositions();
               String question = null;

               for(int i = 0; i < Items.size(); i++){
                   if(booleans.get(i)){
                       question = Items.get(i);
                   }
               }

               Intent intent = new Intent(getApplicationContext(), free_q.class);
               intent.putExtra("Q", question);
               startActivity(intent);
           }
       });

    }
}
