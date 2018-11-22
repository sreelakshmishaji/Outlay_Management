package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ElectricitybillActivity extends AppCompatActivity implements View.OnClickListener {
    Button confirm;
    EditText serviceno;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricitybill);
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        confirm = findViewById(R.id.btnconform);

        confirm.setOnClickListener(this);
        serviceno = findViewById(R.id.edtserviceno);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");

    }

    @Override
    public void onClick(View view) {
        if (view == confirm) {

            String servicenum = serviceno.getText().toString();
            if (servicenum.equals("")) {
                serviceno.setError("Enter Serviceno");
            } else if (!(servicenum.length() >= 9 && servicenum.length() <= 13)) {
                serviceno.setError("Enter a Valid Service Number");
            } else {

                Bill data = new Bill();
                data.execute(id,servicenum);
//                Intent i = new Intent(this, PayElectricityActivity.class);
//                i.putExtra("service", servicenum);
//                startActivity(i);
            }
        }
    }

    private class Bill extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("ebillservice");
            wc.addProperty("Personid", strings[0]);
            wc.addProperty("Serviceno", strings[1]);
            wc.callWebService();
            return wc.getResponse();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

//            Toast.makeText(ElectricitybillActivity.this, s, Toast.LENGTH_SHORT).show();
            String bill="";
            JSONArray ji= null;
            try {
                ji = new JSONArray(s);
                JSONObject jos = ji.getJSONObject(0);
                bill = jos.getString("BillNo");

                if(bill.equals("0"))
                {
                    Toast.makeText(ElectricitybillActivity.this, "Incorrect Service Number", Toast.LENGTH_SHORT).show();
                    serviceno.setText("");
                }
                else
                {
                    Intent i = new Intent(ElectricitybillActivity.this, PayElectricityActivity.class);
                    i.putExtra("service", s);
                    startActivity(i);
                }
            }
            catch(Exception e)
            {

            }


        }
    }
}



