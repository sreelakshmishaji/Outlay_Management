package com.example.sree.outlaymanagement;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    EditText t1, t2, t3, t4, t5;
    Button edit,cancel;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        t1 = findViewById(R.id.edtname);
        t2 = findViewById(R.id.edtgnd);
        t3 = findViewById(R.id.edtemail);
        t4 = findViewById(R.id.edtphn);
        t5 = findViewById(R.id.edthname);
        edit=findViewById(R.id.btnedit);
        edit.setOnClickListener(this);
        cancel=findViewById(R.id.btncnl);
        cancel.setOnClickListener(this);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        view v=new view();
        v.execute(id);

    }

    @Override
    public void onClick(View view) {
        if(view==edit) {
            String name = t1.getText().toString();
            String gender = t2.getText().toString();
            String email = t3.getText().toString();
            String phno = t4.getText().toString();
            String hname = t5.getText().toString();
            update u = new update();
            u.execute(id, name, gender, email, phno, hname);
        }
        if(view==cancel) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");


        }

    }

    private class update extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w1=new WebServiceCaller();
            w1.setSoapObject("update");
            w1.addProperty("Id",strings[0]);
            w1.addProperty("Name",strings[1]);
            w1.addProperty("Gender",strings[2]);
            w1.addProperty("Email",strings[3]);
            w1.addProperty("Phone",strings[4]);
            w1.addProperty("House",strings[5]);
            w1.callWebService();
            return w1.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ViewActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            if(s.equals("true"))
            {
                Toast.makeText(ViewActivity.this, "Profile Updatec", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private class view extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("fetch");
            w.addProperty("Id", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ViewActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            try {
                JSONArray j=new JSONArray(s);
                JSONObject jo= j.getJSONObject(0);
                String name   = jo.getString("Name");
                String gender = jo.getString("Gender");
                String email  = jo.getString("Email");
                String phone  = jo.getString("Phone");
                String home   = jo.getString("Housename");

                t1.setText(name);
                t2.setText(gender);
                t3.setText(email);
                t4.setText(phone);
                t5.setText(home);
            }
            catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}
