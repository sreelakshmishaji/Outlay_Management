package com.example.sree.outlaymanagement;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MonthlyReviewActivity extends AppCompatActivity {
EditText income,expense,savings;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_review);
        income=findViewById(R.id.edtincome);
        expense=findViewById(R.id.edtexpense);
        savings=findViewById(R.id.edtsvngs);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        view v=new view();
        v.execute(id);
    }
    private class view extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("monthlyreview");
            w.addProperty("personid", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MonthlyReviewActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            try {
                JSONArray ji = new JSONArray(s);
                JSONObject jos = ji.getJSONObject(0);
                income.setText(jos.getString("income"));
                expense.setText(jos.getString("expense"));
                savings.setText(jos.getString("savings"));
            }
            catch(Exception e)
            {

            }

        }
    }
}
