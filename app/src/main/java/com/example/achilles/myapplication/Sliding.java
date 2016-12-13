package com.example.achilles.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SlidingDrawer;

/**
 * Created by Achilles on 12/5/2016.
 */

public class Sliding extends Activity implements View.OnClickListener,CheckBox.OnCheckedChangeListener,SlidingDrawer.OnDrawerOpenListener,SlidingDrawer.OnDrawerCloseListener{

    Button btn1,btn2,btn3,btn4;
    CheckBox check;
    SlidingDrawer slidingDrawer;
    String[] nameArray = {"Aestro", "Blender", "Cupcake", "Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb", "IceCream Sandwich", "JelliBean", "KitKat", "Lollipop", "MarshMallow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.handle);

        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);
        slidingDrawer.setOnDrawerOpenListener(this);
        slidingDrawer.setOnDrawerCloseListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameArray));
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn1:
                slidingDrawer.open();
                break;
            case R.id.btn2:
                slidingDrawer.close();
                break;
            case R.id.btn3:
                slidingDrawer.toggle();
                break;
        }

    }

    @Override
    public void onDrawerOpened() {
        btn4.setText("Open");
    }

    @Override
    public void onDrawerClosed() {
        btn4.setText("Close");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked())
        {
            slidingDrawer.lock();
        }
        else
        {
            slidingDrawer.unlock();
        }
    }
}
