package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Achilles on 12/7/2016.
 */

public class Sharedprefs extends Activity implements View.OnClickListener {

    public static String filename="MySharedprefs";
    SharedPreferences share;
    EditText edata;
    Button save,load;
    TextView tvfinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedprefs);
        edata = (EditText) findViewById(R.id.etdata);
        save = (Button) findViewById(R.id.bsave);
        load = (Button) findViewById(R.id.bload);
        tvfinal = (TextView) findViewById(R.id.tvfinal);
        share = getSharedPreferences(filename,MODE_PRIVATE);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bsave :
                String str = edata.getText().toString();
                SharedPreferences.Editor editor = share.edit();
                editor.putString("sharedkey",str);
                editor.commit();
                break;
            case R.id.bload :
                share = getSharedPreferences(filename,MODE_PRIVATE);
                String loaded = share.getString("sharedkey","cannot load");
                tvfinal.setText(loaded);
                break;
        }

    }
}
