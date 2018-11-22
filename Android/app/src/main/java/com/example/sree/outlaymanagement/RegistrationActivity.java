package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Button r1,r2;
    EditText name,email,phn,hname,pswd,cpswd,usid;
    RadioButton ml,fl;
    RadioGroup gender;
    String g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        r1=findViewById(R.id.btnreg);
        r1.setOnClickListener(this);
        r2=findViewById(R.id.btncnl);
        r2.setOnClickListener(this);
        ml=findViewById(R.id.rdbtn1);
        fl=findViewById( R.id.rdbtn2);
        gender=findViewById(R.id.rdgender);
        gender.setOnCheckedChangeListener(this);
        name=findViewById(R.id.edtname);
        email=findViewById(R.id.edtemail);
        phn=findViewById(R.id.edtphn);
        hname=findViewById(R.id.edthname);
        pswd=findViewById(R.id.edtpswd);
        cpswd=findViewById(R.id.edtcnfrm);
        usid=findViewById(R.id.edtuserid);
    }



    private boolean isValidMail(String email) {
        boolean check;
        Pattern p;
        Matcher m;

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        p = Pattern.compile(EMAIL_STRING);

        m = p.matcher(email);
        check = m.matches();

        return check;
    }


    @Override
    public void onClick(View view) {
        String nam=name.getText().toString();
        String mail=email.getText().toString();
        String phno=phn.getText().toString();
        String hnam=hname.getText().toString();
        String pw=pswd.getText().toString();
        String cps=cpswd.getText().toString();
        String uid=usid.getText().toString();
        if(view==r1){

           if(nam.equals(""))
           {
               name.setError("Empty name field");
           }

           else if(mail.equals(""))
           {
               email.setError("Enter Email");
           }
           else if(!isValidMail(mail))
           {
                email.setError("Not Valid Email");
           }
            else if(phno.equals(""))
           {
               phn.setError("Enter phn no");
           }
           else if(phno.length()!=10)
           {
               phn.setError("10 digits required");
           }
           else if(hnam.equals(""))
           {
               hname.setError("Enter House Name");
           }
           else if(uid.equals(""))
           {
               usid.setError("Enter User Name");
           }
           else if(pw.equals(""))
           {
               pswd.setError("Enter Password");
           }
           else if(cps.equals(""))
           {
               cpswd.setError("Retype password");
           }
           else if(!cps.equals(pw)){
                cpswd.setError("Password Missmatch");
            }
//           else if(g.equals(""))
//           {
//               Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
//           }
    else{
//               Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
               Register1 reg = new Register1();
               reg.execute(nam,g,mail,phno,hnam,uid,pw);

    }

}
     else if(view==r2){

        phn.setText("");
        email.setText("");
        name.setText("");
        hname.setText("");
        pswd.setText("");
        cpswd.setText("");
        usid.setText("");
        ml.setChecked(false);
        fl.setChecked(false);
        gender.setSelected(false);

    }

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if(i==R.id.rdbtn1)
        {
            g=ml.getText().toString();

        }
        else
        {
            g=fl.getText().toString();
        }

    }

    private class Register1 extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings) {

            WebServiceCaller wc=new WebServiceCaller();
            wc.setSoapObject("registration");
            wc.addProperty("Name",strings[0]);
            wc.addProperty("Gender",strings[1]);
            wc.addProperty("Email",strings[2]);
            wc.addProperty("Phone",strings[3]);
            wc.addProperty("House",strings[4]);
            wc.addProperty("Userid",strings[5]);
            wc.addProperty("Password",strings[6]);
            wc.callWebService();
            return wc.getResponse();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            if(s.equals("true")){
                Toast.makeText(RegistrationActivity.this, "Sucessfully registerd", Toast.LENGTH_SHORT).show();
                phn.setText("");
                email.setText("");
                name.setText("");
                hname.setText("");
                pswd.setText("");
                cpswd.setText("");
                usid.setText("");
            }
        }
    }
}
