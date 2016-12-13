package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Achilles on 12/2/2016.
 */

public class SoundStuff1 extends Activity implements View.OnClickListener{

    Button button1,button2,button3,button4,button5,button6;
    SoundPool sp;
    int explosion=0,mystreamid;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound);
        initializevars();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        context = this;
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
    }

    private void initializevars() {
        button1 = (Button)findViewById(R.id.butto1);
        button2 = (Button) findViewById(R.id.butto2);
        button3 = (Button) findViewById(R.id.butto3);
        button4 = (Button) findViewById(R.id.butto4);
        button5 = (Button) findViewById(R.id.butto5);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.butto1:
                explosion = sp.load(getApplicationContext(),R.raw.clip1,1);
                Toast.makeText(getApplicationContext(),"clip1 loaded",Toast.LENGTH_SHORT).show();
                break;
            case R.id.butto2:
                explosion = sp.load(getApplicationContext(),R.raw.clip2,1);
                Toast.makeText(getApplicationContext(),"clip2 loaded",Toast.LENGTH_SHORT).show();
                break;
            case R.id.butto3:
                explosion = sp.load(getApplicationContext(),R.raw.moore,1);
                Toast.makeText(getApplicationContext(),"clip3 loaded",Toast.LENGTH_SHORT).show();
                break;
            case R.id.butto4:
                mystreamid=sp.play(explosion,1,1,1,1,1);
                break;
            case R.id.butto5:
                sp.stop(mystreamid);
                break;
        }
    }
}
