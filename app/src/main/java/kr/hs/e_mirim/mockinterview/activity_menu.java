package kr.hs.e_mirim.mockinterview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import java.util.ArrayList;

public class activity_menu extends TabActivity {
    int but = 0;
    //private Button btn = (Button)findViewById(R.id.tip_btn1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final TabHost tabHost=getTabHost();
        ArrayList<TabHost.TabSpec> tabSpecs= new ArrayList<TabHost.TabSpec>();
        String[] texts={"면접", "Tip", "커뮤니티", "My"};
        for(int i = 0; i < 4; i++){
            tabSpecs.add(tabHost.newTabSpec("a" + (i+1)).setIndicator(texts[i]));
        }

        int j=0;
        for(TabHost.TabSpec tabspec:tabSpecs){
            tabspec.setContent(R.id.view1 + j);
            tabHost.addTab(tabspec);
            j++;
        }

        setTabColor(tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String arg0) {

                setTabColor(tabHost);
            }
        });

        Button mockInterview=findViewById(R.id.mockinterview);
        mockInterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), mockActivity.class);
                startActivity(intent);
            }
        });

        Button freeInterview=findViewById(R.id.freeinterview);
        freeInterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), free.class);
                startActivity(intent);
            }
        });

    }

    public static void setTabColor(TabHost tabhost) {

        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.white/*R.drawable.header_blank*/); // unselected
//            TextView tv = (TextView)tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab());
//            tv.setT
        }
        tabhost.getTabWidget().setCurrentTab(0);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                .setBackgroundResource(R.color.colorMain/*R.drawable.tab_selected_new*/); // selected
        // //have
        // to
        // change
    }

}
