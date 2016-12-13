package com.example.achilles.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Achilles on 12/9/2016.
 */

public class asynctask extends Activity implements View.OnClickListener {

    TextView tvfin;
    Button btn1;
    EditText etsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctask);
        etsearch = (EditText) findViewById(R.id.etsearch);
        btn1 = (Button) findViewById(R.id.basync);
        tvfin = (TextView) findViewById(R.id.tvfin);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.basync :
                String val = etsearch.getText().toString();
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute(val);
                break;

        }
    }

    public class AsyncTaskRunner extends AsyncTask<String,String,String> {

        ProgressDialog progressDialog;
        String resp;
        int time;
        @Override
        protected String doInBackground(String... params) {

            publishProgress("sleeping");
            try {
                time = Integer.parseInt(params[0]);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            }catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }


               /* int start = (int) System.currentTimeMillis();
                int update = 0;
                while(update != time)
                {
                    update = (int) (System.currentTimeMillis()-start);
                    publishProgress(Integer.toString(start-update));
                }*/
                resp = "Waited For "+params[0]+" seconds";

            return resp;
        }

        @Override
        protected void onPreExecute() {
            progressDialog=ProgressDialog.show(asynctask.this,
                    "ProgressDialog",
                    "Wait for 5  seconds");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            tvfin.setText(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            tvfin.setText(s);
        }

    }
}

