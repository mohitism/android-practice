package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Achilles on 11/19/2016.
 */

public class OpenedClass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    TextView tvget,tvout;
    RadioButton rbcrazy,rbsmart,rbboth;
    Button breturn;
    RadioGroup seletionlist;
    String settexts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();

       seletionlist.setOnCheckedChangeListener(this);
        SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String preferencestring = getprefs.getString("name",null);
        String values = getprefs.getString("list","4");

        if(values.contentEquals("1"))
            tvout.setText(preferencestring);
       // Bundle gotBasket = getIntent().getExtras();
        //String stringBasket = gotBasket.getString("key");
        //tvout.setText(stringBasket);

        breturn.setOnClickListener(OpenedClass.this);
    }

    private void initialize() {
        tvget = (TextView) findViewById(R.id.tvget);
        tvout = (TextView) findViewById(R.id.tvout);
        rbcrazy = (RadioButton)  findViewById(R.id.rcrazy);
        rbsmart = (RadioButton) findViewById(R.id.rsmart);
        rbboth = (RadioButton) findViewById(R.id.rboth);
        breturn = (Button) findViewById(R.id.breturn);
        seletionlist = (RadioGroup) findViewById(R.id.selectionlist);
    }

    @Override
    public void onClick(View view) {
            Intent i = new Intent(this,Data.class);
            Bundle returnBasket = new Bundle();
            returnBasket.putString("answer",settexts);
            i.putExtras(returnBasket);
            setResult(RESULT_OK,i);
            finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i)
            {
                case R.id.rcrazy :
                    settexts = "fuck i am crazy";
                    break;
                case R.id.rsmart :
                    settexts = "fuck i am smart";
                    break;
                case R.id.rboth :
                    settexts = "fuck i am both smart and crazy";
                    break;
            }
    }
}
