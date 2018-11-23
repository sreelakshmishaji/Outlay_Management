package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button  home, view1,logout,income,ebill,budget,expense,mobile,review,notify,loan,report,wtrbill,insurance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home = findViewById(R.id.homebtn);
        view1 = findViewById(R.id.viewbtn);
        home.setOnClickListener(this);
        view1.setOnClickListener(this);
        logout=findViewById(R.id.lgoutbtn);
        logout.setOnClickListener(this);
        income=findViewById(R.id.incbtn);
        income.setOnClickListener(this);
        ebill=findViewById(R.id.paymenttbtn);
        ebill.setOnClickListener(this);
        budget=findViewById(R.id.budgetbtn);
        budget.setOnClickListener(this);
        expense=findViewById(R.id.expensebtn);
        expense.setOnClickListener(this);
        mobile=findViewById(R.id.mobiletbtn);
        mobile.setOnClickListener(this);
        review=findViewById(R.id.reviewbtn);
        review.setOnClickListener(this);
        notify=findViewById(R.id.notifybtn);
        notify.setOnClickListener(this);
        loan=findViewById(R.id.loanbtn);
        loan.setOnClickListener(this);
        report=findViewById(R.id.reportbtn);
        report.setOnClickListener(this);
        insurance=findViewById(R.id.insurancebtn);
        insurance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == view1) {
            Intent intent = new Intent(this, ViewActivity.class);
            startActivity(intent);
        }
        else if(view==logout)
        {
            Intent i=new Intent(HomeActivity.this,MobileRechargeActivity.LoginActivity.class);
            startActivity(i);
        }
else if (view==income) {
            Intent j=new Intent(HomeActivity.this,IncomeActivity.class);
            startActivity(j);
        }
       else if(view==ebill)
        {
            Intent k=new Intent(HomeActivity.this,ElectricitybillActivity.class);
            startActivity(k);
        }
         if(view==budget){
            Intent b =new Intent(HomeActivity.this,BudgetLineActivity.class);
            startActivity(b);
        }
        if(view==expense){
            Intent e =new Intent(HomeActivity.this,ExpenseActivity.class);
            startActivity(e);
        }

         else if(view==mobile){
             Intent m=new Intent(HomeActivity.this,MobileRechargeActivity.class);
             startActivity(m);
         }
         else if(view==review){
            Intent re=new Intent(HomeActivity.this,MonthlyReviewActivity.class);
            startActivity(re);
        }
        else if(view==notify){
            Intent no=new Intent(this,NotificationActivity.class);
            startActivity(no);
        }
        else if(view==report){
            Intent rpt=new Intent(this,GraphActivity.class);
            startActivity(rpt);
        }


        else if(view==loan){
            Intent ln=new Intent(this,LoanActivity.class);
            startActivity(ln);
        }

        else if(view==insurance){
            Intent ins=new Intent(this,InsuranceActivity.class);
            startActivity(ins);
        }



    }
}
