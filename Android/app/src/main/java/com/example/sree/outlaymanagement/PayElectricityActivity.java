package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PayElectricityActivity extends AppCompatActivity implements View.OnClickListener {
    Button debit;
    TextView billno,name,duedate,amount,statusfield,pay;
    SharedPreferences sh;
    String id;
    String tamount;
    String sh_name = "MyData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_electricity);
        debit=findViewById(R.id.btndebit);
        debit.setOnClickListener(this);
        billno=findViewById(R.id.txtbillno);
        name=findViewById(R.id.txtname);
        duedate=findViewById(R.id.txtdate);
        amount=findViewById(R.id.txtamt);
        statusfield=findViewById(R.id.txtstatus);
        pay=findViewById(R.id.txtpay);

        String serviceno=getIntent().getStringExtra("service");
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
//
        String bill="";
        JSONArray ji= null;
        try {
            ji = new JSONArray(serviceno);
            JSONObject jos= ji.getJSONObject(0);
            bill  = jos.getString("BillNo");
            tamount = jos.getString("Amount");
            String due = jos.getString("Due");
            String name1  = jos.getString("Person");
            String status=jos.getString("Status");
            if(status.equals("0"))
            {
                statusfield.setText("Not Paid");
            }
            if(status.equals("1"))
            {
                statusfield.setText("Already Paid");
                debit.setVisibility(View.INVISIBLE);
                pay.setVisibility(View.INVISIBLE);
            }
            billno.setText(bill);
            amount.setText(tamount);
            duedate.setText(due);
            name.setText(name1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SharedPreferences sh=getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor=sh.edit();
        editor.putString("Amount",tamount);
        editor.putString("Billno",bill);
        editor.commit();

    }

    @Override
    public void onClick(View view) {
        Intent i =new Intent(this,DebitcardActivity.class);
        startActivity(i);
    }



}
