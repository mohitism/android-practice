package com.example.achilles.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Achilles on 12/5/2016.
 */

public class Tabclass extends Activity implements View.OnClickListener {
    TabHost Host;
    Button bstart,bstop,badd,bclear;
    TextView text;
    Handler handle = new Handler();
    long start=0,end=0,update=0,timeswap=0,update1=0;
    TabHost.TabSpec spec;
    int t=1;
    int i=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabclass);
        bstart = (Button) findViewById(R.id.bstarts);
        bstop = (Button) findViewById(R.id.bstops);
        badd = (Button) findViewById(R.id.badds);
        bclear = (Button) findViewById(R.id.bclear);
        Host = (TabHost) findViewById(R.id.tabhost);
        text = (TextView) findViewById(R.id.btext);
        Host.setup();
        spec = Host.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("tab1");
        Host.addTab(spec);

        spec = Host.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("tab2");
        Host.addTab(spec);

        spec = Host.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("tab3");
        Host.addTab(spec);
        bstart.setOnClickListener(this);
        bstop.setOnClickListener(this);
        badd.setOnClickListener(this);
        bclear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bstarts :
                if(t==1)
                {
                    bstart.setText("Pause");
                    start = System.currentTimeMillis();
                    handle.postDelayed(updatetimer,0);
                    t=0;
                }
                else
                {
                    handle.removeCallbacks(updatetimer);
                    timeswap+=update1;
                    bstart.setText("Start");
                    t=1;
                }

                break;
            case R.id.bstops :
                start=0;
                end=0;
                update=0;
                timeswap=0;
                update1=0;
                t=1;
                text.setText("00:00:00");
                break;

            case R.id.badds :
                spec= Host.newTabSpec(("tag"+i)).setIndicator("tab"+i).setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String s) {
                        TextView textView = new TextView(getApplicationContext());
                        textView.setText("new tab");
                        return textView;
                    }
                });
                Host.addTab(spec);
                i++;
                break;

            case R.id.bclear :
                Host.getTabWidget().removeView(Host.getTabWidget().getChildTabViewAt(Host.getCurrentTab()));
                break;
        }

    }

    public Runnable updatetimer= new Runnable() {
        @Override
        public void run() {
            update1 = System.currentTimeMillis() - start;
            update=timeswap+update1;
            int secs =(int) update/1000;
            int mins = (int)secs/60;
            int millis = (int)(update)%1000;
            secs = secs%60;
            text.setText("" + mins + ":" + String.format("%02d", secs) + ":" + String.format("%03d", millis));
            text.setTextColor(Color.RED);
            handle.postDelayed(this,0);
        }
    };
}
