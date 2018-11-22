package com.example.sree.outlaymanagement;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InsuranceActivity extends AppCompatActivity {
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    Adapterinsurance adapt;
    List<Beaninsurance> blist;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        blist=new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.insrecycler);

        insurance ins=new insurance();
        ins.execute(id);
    }

    public class insurance extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("insurance");
            w.addProperty("Personid", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d ("all is well",s);
            JSONArray ji= null;
            try {
                ji = new JSONArray(s);

                for(int i=0;i<ji.length();i++){
                    JSONObject jos= ji.getJSONObject(i);
                    String name  = jos.getString("name");
                    String amount = jos.getString("amount");
                    String duration = jos.getString("duration");
                    String company  = jos.getString("company");
                    String phone = jos.getString("phone");
                    String email  = jos.getString("email");
                    Beaninsurance bb=new Beaninsurance();
                    bb.setName1(name);
                    bb.setAmount1(amount);
                    bb.setDuration(duration);
                    bb.setCompany(company);
                    bb.setPhone(phone);
                    bb.setEmail(email);
                    blist.add(bb);
                }
                adapt=new Adapterinsurance(blist,InsuranceActivity.this);
                recycler.setLayoutManager(new LinearLayoutManager(InsuranceActivity.this));
                recycler.setAdapter(adapt);
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
