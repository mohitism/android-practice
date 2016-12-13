package com.example.achilles.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by Achilles on 12/7/2016.
 */

public class Flipper extends Activity implements View.OnClickListener {

    ViewFlipper flip;
    Button bflip;
    TextView tvflip,tvflip1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        bflip = (Button) findViewById(R.id.bflip);
        tvflip = (TextView) findViewById(R.id.tvflip);
        tvflip1 = (TextView) findViewById(R.id.tvflip1);
        flip = (ViewFlipper) findViewById(R.id.flipper);
        flip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        flip.showNext();
    }
}
