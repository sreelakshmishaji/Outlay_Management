package com.example.sree.outlaymanagement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class GraphActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    Button generate;
    EditText from,to;
    Button f, t;
    Spinner type;
     int day=0;
     int month=0;
     int Year=2018;
     int flag=0;
    DatePickerDialog datePickerDialog,datePickerDialog1;
    Calendar myCalendar = Calendar.getInstance();
String incometypename[]={"Select","Pie Chart","Expense Bar Chart","Income Bar Chart"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        generate=findViewById(R.id.btngener);
        generate.setOnClickListener(this);
        from=findViewById(R.id.edtfrm);
        to=findViewById(R.id.edtto);
        type=findViewById(R.id.sptype);
        f=findViewById(R.id.buttonFrom);
        t= findViewById(R.id.buttonto);
        f.setOnClickListener(this);
        t.setOnClickListener(this);

        ArrayAdapter <String> income =
                new ArrayAdapter<String>(GraphActivity.this,android.R.layout.simple_spinner_item,incometypename);
        income.setDropDownViewResource(android.R.layout.simple_spinner_item);
        type.setAdapter(income);

    }


    @Override
    public void onClick(View view) {
        if(view== f){
             datePickerDialog = new DatePickerDialog(
                    GraphActivity.this, GraphActivity.this, Year, month, day);
            datePickerDialog.show();
        }
        else if(view == t){
            datePickerDialog1 = new DatePickerDialog(
                    GraphActivity.this, GraphActivity.this, Year, month, day);
            datePickerDialog1.show();
        }
        else if(view== generate) {
            if(type.getSelectedItem().equals("Pie Chart")){

                Intent i = new Intent(this, GenerateChartActivity.class);
            i.putExtra("startDate", from.getText().toString());
            i.putExtra("endDate", to.getText().toString());

            i.putExtra("type", type.getSelectedItem().toString());


            startActivity(i);
            }
        if(type.getSelectedItem().equals("Expense Bar Chart")){
            Intent i = new Intent(this,ExpensebarchartActivity.class);
            i.putExtra("startDate",from.getText().toString());
            i.putExtra("endDate",to.getText().toString());

            i.putExtra("type",type.getSelectedItem().toString());
startActivity(i);
        }
            if(type.getSelectedItem().equals("Income Bar Chart")){
                Intent i= new Intent(this,IncomebarchartActivity.class);
                i.putExtra("startDate",from.getText().toString());
                i.putExtra("endDate",to.getText().toString());

                i.putExtra("type",type.getSelectedItem().toString());
                startActivity(i);
            }

        }

    }





    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        int y = year;
        int m = monthOfYear+1;
        int d  = dayOfMonth;

        if(flag==0){
           from.setText(y+"-"+m+"-"+d);
           flag++;
        }
        else{
            to.setText(y+"-"+m+"-"+d);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        
    }
}
