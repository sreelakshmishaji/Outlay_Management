package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class DebitcardActivity extends AppCompatActivity implements View.OnClickListener {
    Button ok, cancel, save;
    EditText cardno, mm, yy, cvv;
    SharedPreferences sh;
    String id;
    String amt;
    String sh_name = "MyData";
String billno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debitcard);
        ok = findViewById(R.id.btnok);
        ok.setOnClickListener(this);
        cancel = findViewById(R.id.btncancel);
        cancel.setOnClickListener(this);
        save = findViewById(R.id.btnsave);
        save.setOnClickListener(this);
        cardno = findViewById(R.id.edtcrdno);
        mm = findViewById(R.id.edtmm);
        yy = findViewById(R.id.edtyy);
        cvv = findViewById(R.id.edtcvv);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        amt = sh.getString("Amount", " ");
        billno=sh.getString("Billno","");
        dcard dc = new dcard();
        dc.execute(id);
        Toast.makeText(this, "All is well : "+id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        String card = cardno.getText().toString();
        String month = mm.getText().toString();
        String year = yy.getText().toString();
        String cv = cvv.getText().toString();
        int mon = Integer.parseInt(month);
        int yr = Integer.parseInt(year);
        if (view == ok) {

            if (card.equals("")) {
                cardno.setError("Enter Cardno");
            } else if (!(card.length() == 16)) {
                cardno.setError("Enter a Valid card Number");
            } else if (cvv.getText().equals("")) {
                cvv.setError("Enter CVV");
            } else if (!(cvv.getText().length() == 3)) {
                cvv.setError("Enter a Valid CVV");
            } else if (mm.getText().equals("")) {
                mm.setError("Enter Month");
            } else if (!(mon > 0 && mon < 13)) {
                mm.setError("Enter a valid Month");
            } else if (year.equals("")) {
                yy.setError("Enter Year");
            } else if (!(yr >= 18)) {
                yy.setError("Enter a valid year");
            } else {
                Toast.makeText(this, "Payment Sucessfull", Toast.LENGTH_SHORT).show();
                expense exp = new expense();
                exp.execute(amt, id,billno);
            }

        } else if (view == cancel) {
            cardno.setText("");
            mm.setText("");
            yy.setText("");
            cvv.setText("");

        } else if (view == save) {

            save sv = new save();
            sv.execute(card, month, year, id);
//Toast.makeText(this,"+month+year+cv",Toast.LENGTH_SHORT).show();

        }
    }

    private class expense extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("addexpense");
            wc.addProperty("Amount", strings[0]);
            wc.addProperty("Personid", strings[1]);
            wc.addProperty("Billno", strings[2]);
            wc.callWebService();
            return wc.getResponse();
        }
    }

    private class save extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("save");
            wc.addProperty("CardNo", strings[0]);
            wc.addProperty("Month", strings[1]);
            wc.addProperty("Year", strings[2]);
            wc.addProperty("Personid", strings[3]);
            wc.callWebService();
            return wc.getResponse();

        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.equals("true")) {
                Toast.makeText(DebitcardActivity.this, "Sucessfully saved", Toast.LENGTH_SHORT).show();
                mm.setText("");
                yy.setText("");
                cvv.setText("");

            }
        }
    }

    private class dcard extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("carddetails");
            w.addProperty("Personid", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(DebitcardActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            Log.d("alliswell",s);
            try {
                JSONArray j=new JSONArray(s);
                JSONObject jo= j.getJSONObject(0);
                String number   = jo.getString("CardNo");
                String mnth = jo.getString("Month");
                String yrs  = jo.getString("Year");


                cardno.setText(number);
                mm.setText(mnth);
                yy.setText(yrs);

            }
            catch (Exception e) {
                e.printStackTrace();

            }
        }
    }


}
