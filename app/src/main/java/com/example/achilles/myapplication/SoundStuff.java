package com.example.achilles.myapplication;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Achilles on 12/1/2016.
 */

public class SoundStuff extends Activity implements View.OnClickListener,View.OnLongClickListener{

    SoundPool sp;
    int explosion=0;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new View(this);
        setContentView(v);
        v.setOnClickListener(this);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explosion = sp.load(this,R.raw.clip2,1);
        mp = MediaPlayer.create(this,R.raw.moore);
        v.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(explosion != 0)
        {
            sp.play(explosion,1,1,1,0,1);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        mp.start();
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
    }

}
