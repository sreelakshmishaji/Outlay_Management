package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MobileRechargeActivity extends AppCompatActivity implements View.OnClickListener {
    Button debit;
    TextView phone,amount;
    Spinner provider;
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    ArrayAdapter <String> service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_recharge);
        debit=findViewById(R.id.btndebit);
        debit.setOnClickListener(this);
        phone=findViewById(R.id.edtphn);
        amount=findViewById(R.id.edtamount);
        provider=findViewById(R.id.spprovider);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
    }

    @Override
    public void onClick(View view) {
        String phoneno = phone.getText().toString();
        String amt = amount.getText().toString();

        recharge rchg= new recharge();
        rchg.execute(phoneno,amt);

        Intent i =new Intent(this,DebitcardActivity.class);
        startActivity(i);
    }

    private class recharge extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("mobilerecharge");
            wc.addProperty("phone", strings[0]);
            wc.addProperty("amount", strings[1]);
            wc.callWebService();
            return wc.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent i =new Intent(MobileRechargeActivity.this,DebitcardActivity.class);
            startActivity(i);

        }
    }

    public static class LoginActivity extends AppCompatActivity implements View.OnClickListener {
        EditText uname, pss;
        Button log,cancel;
        Button user;
        String userid, pswd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            pss = findViewById(R.id.edtpwd);
            uname = findViewById(R.id.edtuid);
            log = findViewById(R.id.btnlogin);
            log.setOnClickListener(this);
            cancel=findViewById(R.id.btncancel);
            cancel.setOnClickListener(this);
            user = findViewById(R.id.newusr);
            user.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (view == log)
            {
                userid = uname.getText().toString();
            pswd = pss.getText().toString();


            login l = new login();
            l.execute(userid, pswd);
        }
            if (view == user) {
                Intent intent = new Intent(this, RegistrationActivity.class);
                startActivity(intent);

            }
            if(view==cancel) {
            uname.setText("");
            pss.setText("");
            }
        }

        private class login extends AsyncTask<String, String, String> {
            @Override
            protected String doInBackground(String... strings) {
                WebServiceCaller w = new WebServiceCaller();
                w.setSoapObject("select");
                w.addProperty("Userid", strings[0]);
                w.addProperty("Password", strings[1]);
                w.callWebService();

                return w.getResponse();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(s.contains("true")){
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();



                    String arr[]=s.split(",");
                    String id=arr[0];
                    Toast.makeText(LoginActivity.this, ""+id, Toast.LENGTH_SHORT).show();
                    SharedPreferences sh=getSharedPreferences("MyData",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sh.edit();
                    editor.putString("User_id",id);
                    editor.commit();

                    Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(LoginActivity.this, "Incorrect username or password" , Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}

