package com.example.sree.outlaymanagement;

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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpenseActivity extends AppCompatActivity implements View.OnClickListener {
    Button done, cancel;
    //   DatePickerDialog dpd;
    DatePicker datePickerDate;
    EditText amount;
    Spinner name;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";

    ArrayAdapter<String> expense;

    String expensetypename[];
    String expensetypeid[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
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

        ExpenseActivity.SelectExpenseType sip=new ExpenseActivity.SelectExpenseType();
        sip.execute();
    }

    @Override
    public void onClick(View view) {
        String amt = amount.getText().toString();
        String expense=expensetypeid[name.getSelectedItemPosition()];
        if (view == done) {
            String day=datePickerDate.getDayOfMonth()+"";
            String m=datePickerDate.getMonth()+"";
            int month=Integer.parseInt(m)+1;
            String year=datePickerDate.getYear()+"";
            String dt = year+"-"+month+"-"+day;

            Toast.makeText(this, "" + dt, Toast.LENGTH_SHORT).show();

            confirm c = new confirm();
            c.execute(expense,amt,dt,id);
        } else if (view == cancel) {
            amount.setText("");

        }
    }

    private class confirm extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("expenseadd");
            w.addProperty("Expense", strings[0]);
            w.addProperty("Amount", strings[1]);
            w.addProperty("Date", strings[2]);
            w.addProperty("id", strings[3]);
            w.callWebService();

            return w.getResponse();

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.contains("true")) {
                Toast.makeText(ExpenseActivity.this, "Expense Entered", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(ExpenseActivity.this, "Expense not Entered" , Toast.LENGTH_SHORT).show();

            }
        }
    }
    private class SelectExpenseType extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc=new WebServiceCaller();
            wc.setSoapObject("selectexpense");
            wc.callWebService();
            return  wc.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Toast.makeText(ExpenseActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            try{
                JSONArray ji =new JSONArray(s);
                expensetypeid= new String[ji.length()];
                expensetypename=new String[ji.length()];
//                incometypename[0]="select";
//                incometypeid[0]="sel";
                for(int i=0;i<ji.length();i++){


                    JSONObject jos=ji.getJSONObject(i);
                    expensetypename[i]=jos.getString("Name");
                    expensetypeid[i]=jos.getString("Id");
                    Log.d("sreelakshmi",expensetypename[i]);
                }
                expense=new ArrayAdapter<String>(ExpenseActivity.this,android.R.layout.simple_spinner_item,expensetypename);
                expense.setDropDownViewResource(android.R.layout.simple_spinner_item);
                name.setAdapter(expense);
                Log.d("sreelakshmi",expensetypename[1]);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    }



