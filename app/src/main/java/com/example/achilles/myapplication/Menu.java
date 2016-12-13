package com.example.achilles.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Achilles on 11/13/2016.
 */

public class Menu extends ListActivity{

    String classes[] = {"MainActivity","TextPlay","Email","Camera","Data","GFX","GFXSurface","SoundStuff","SoundStuff1","Sliding","Tabclass","Webbased","Sharedprefs","Flipper","asynctask"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class list1 = Class.forName("com.example.achilles.myapplication." + cheese);
            Intent ourintent = new Intent(this,list1);
            startActivity(ourintent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowup = getMenuInflater();
        blowup.inflate(R.menu.cool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.aboutus :
                Intent i = new Intent("com.example.achilles.myapplication.ABOUTUS");
                startActivity(i);
                break;
            case R.id.preferences :
                Intent il = new Intent("com.example.achilles.myapplication.PREFS");
                startActivity(il);
                break;
            case R.id.exit :
                finish();
        }
        return true;
    }
}

