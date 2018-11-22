package com.example.sree.outlaymanagement;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IncomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button done, cancel;
    //   DatePickerDialog dpd;
    DatePicker datePickerDate;
    EditText amount;
    Spinner name;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";

    ArrayAdapter <String> income;

    String incometypename[];
    String incometypeid[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
//        date = findViewById(R.id.btndate);
//        date.setOnClickListener(this);
        name=findViewById(R.id.myspinner);
        amount=findViewById(R.id.edtamt);
        datePickerDate = (DatePicker) findViewById(R.id.datePickerDate);
        datePickerDate.setOnClickListener(this);
        done = findViewById(R.id.btndon);
        done.setOnClickListener(this);
        cancel = findViewById(R.id.btncancel);
        cancel.setOnClickListener(this);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");

        SelectIncomeType sip=new SelectIncomeType();
        sip.execute();
    }

    @Override
    public void onClick(View view) {
        String amt = amount.getText().toString();
        String incom=incometypeid[name.getSelectedItemPosition()];
        if (view == done) {
            String day=datePickerDate.getDayOfMonth()+"";
            String m=datePickerDate.getMonth()+"";
            int month=Integer.parseInt(m)+1;
            String year=datePickerDate.getYear()+"";
            String dt = year+"-"+month+"-"+day;

            Toast.makeText(this, "" + dt, Toast.LENGTH_SHORT).show();

            confirm c = new confirm();
            c.execute(incom,amt,dt,id);
        } else if (view == cancel) {
            amount.setText("");

        }

    }


    private class confirm extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("incomeadd");
            w.addProperty("Income", strings[0]);
            w.addProperty("Amount", strings[1]);
            w.addProperty("Date", strings[2]);
            w.addProperty("id", strings[3]);
            w.callWebService();

            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("sreelakshmi",s);
            if (s.contains("true")) {
                Toast.makeText(IncomeActivity.this, "Income Entered", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(IncomeActivity.this, "Income not Entered" , Toast.LENGTH_SHORT).show();

            }
        }
    }

    private class SelectIncomeType extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc=new WebServiceCaller();
            wc.setSoapObject("selectIncome");
            wc.callWebService();
            return  wc.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("sreelakshmi",s);
             try{
                JSONArray ji =new JSONArray(s);
                incometypename= new String[ji.length()];
                incometypeid=new String[ji.length()];
//                incometypename[0]="select";
//                incometypeid[0]="sel";
                for(int i=0;i<ji.length();i++){


                    JSONObject jos=ji.getJSONObject(i);
                    incometypename[i]=jos.getString("Name");
                    incometypeid[i]=jos.getString("Id");
                    Log.d("sreelakshmi",incometypename[i]);
                }
    income=new ArrayAdapter<String>(IncomeActivity.this,android.R.layout.simple_spinner_item,incometypename);
            income.setDropDownViewResource(android.R.layout.simple_spinner_item);
            name.setAdapter(income);
            Log.d("sreelakshmi",incometypename[1]);

            } catch (JSONException e) {
            e.printStackTrace();
        }

        }
    }
}