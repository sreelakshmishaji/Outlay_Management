package com.example.sree.outlaymanagement;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BudgetLineActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
SeekBar budget;
Button ok;
TextView budglabel,budamount;
    int seek=0;
SharedPreferences sh;
    String id;
    int maxValue=0;
    int progressValue=100;
    String sh_name = "MyData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_line);
        budget=findViewById(R.id.seekBar);
        budglabel=findViewById(R.id.txt);
        budamount=findViewById(R.id.txtBudgetAmount);

        budget.setMax(0);
        budget.setProgress(progressValue);
        budget.setOnSeekBarChangeListener(this);
        ok=findViewById(R.id.donebtn);
        ok.setOnClickListener(this);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", "");
        getincome gti = new getincome();
        gti.execute(id);
    }

    @Override
    public void onClick(View view) {
        id = sh.getString("User_id", "");

        Log.d("sreelakshmi",id);

        String seeeek = seek+"";
        income in=new income();
        in.execute(seeeek,id);
    }
private class income extends AsyncTask<String,String,String>{

    @Override
    protected String doInBackground(String... strings) {
        WebServiceCaller wc = new WebServiceCaller();
        wc.setSoapObject("getbudget");
        wc.addProperty("Amount", strings[0]);
        wc.addProperty("Personid", strings[1]);


        wc.callWebService();
        return wc.getResponse();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(BudgetLineActivity.this, ""+s, Toast.LENGTH_SHORT).show();
        if(s.equals("false"))
        {
            Toast.makeText(BudgetLineActivity.this, "failed", Toast.LENGTH_SHORT).show();
        }
        else {
            budamount.setText("");
            budamount.setText(s);
        }
    }
}
    private class getincome extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("budgetline");
            wc.addProperty("personid", strings[0]);
            wc.callWebService();
            return wc.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray j = new JSONArray(s);
                JSONObject jo= j.getJSONObject(0);


                String income=jo.getString("income");
                String budjet=jo.getString("budget");

                if(budjet.equals("0"))
                {
                    budglabel.setVisibility(View.INVISIBLE);
                    budamount.setVisibility(View.INVISIBLE);
                }
                else
                {
                    budamount.setText(budjet);
                }


                maxValue= Integer.parseInt(income);

                budget.setMax(maxValue);
                budget.setProgress(progressValue);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
         seek = budget.getProgress();
        Toast.makeText(this, ""+seek, Toast.LENGTH_SHORT).show();
    }


    }

