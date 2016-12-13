package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Achilles on 11/19/2016.
 */

public class Data extends Activity implements View.OnClickListener {

    EditText etext;
    Button sactivity,saresult;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialize();
        sactivity.setOnClickListener(Data.this);
        saresult.setOnClickListener(Data.this);
    }

    private void initialize() {
        etext = (EditText) findViewById(R.id.etsend);
        sactivity = (Button) findViewById(R.id.bSAs);
        saresult = (Button) findViewById(R.id.bSAFRs);
        tv = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bSAs :
                String value = etext.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key",value);
                Intent i = new Intent(this,OpenedClass.class);
                i.putExtras(basket);
                startActivity(i);
                break;
            case R.id.bSAFRs :
                String value1 = etext.getText().toString();
                Bundle basket1 = new Bundle();
                basket1.putString("key",value1);
                Intent il = new Intent(this,OpenedClass.class);
                il.putExtras(basket1);
                startActivityForResult(il,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            String bmp =  extras.getString("answer");
            tv.setText(bmp);
        }

    }

}
