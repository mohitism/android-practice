package com.example.achilles.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by Achilles on 11/14/2016.
 */

public class TextPlay extends Activity implements View.OnClickListener{
    EditText editbutton ;
    Button command;
    ToggleButton toggle;
    TextView validity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        editbutton = (EditText) findViewById(R.id.etCommands);
        command = (Button) findViewById(R.id.tvResults);
        toggle = (ToggleButton) findViewById(R.id.tbpassword);
        validity = (TextView) findViewById(R.id.results);

        toggle.setOnClickListener(this);

        command.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tbpassword :
                if(toggle.isChecked())
                {
                    editbutton.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    editbutton.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
            case R.id.tvResults :
                String mystring = editbutton.getText().toString();

                if(mystring.contentEquals("left"))
                {
                    validity.setGravity(Gravity.LEFT);
                }
                else if(mystring.contentEquals("right"))
                {
                    validity.setGravity(Gravity.RIGHT);
                }
                else if(mystring.contentEquals("center"))
                {
                    validity.setGravity(Gravity.CENTER);
                }
                else if(mystring.contentEquals("blue"))
                {
                    validity.setTextColor(Color.BLUE);
                }
                else if(mystring.contains("WTF"))
                {
                    Random val = new Random();
                    validity.setTextSize(val.nextInt(100));
                    validity.setText("WTF");
                    switch(val.nextInt(3))
                    {
                        case 0 :
                            validity.setGravity(Gravity.LEFT);
                            break;
                        case 1 :
                            validity.setGravity(Gravity.CENTER);
                            break;
                        case 2 :
                            validity.setGravity(Gravity.RIGHT);
                            break;
                        default:
                            validity.setGravity(Gravity.CENTER);
                            validity.setText("invalid");
                    }
                }
                else
                {
                    validity.setText("invalid");
                    validity.setGravity(Gravity.CENTER);
                }
                break;
        }
    }
}
