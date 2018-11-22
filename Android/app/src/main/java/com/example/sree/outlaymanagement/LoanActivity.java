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

public class LoanActivity extends AppCompatActivity {
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    Adapterloan adapt;
    List<Beanloan> blist;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        blist=new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.recycler);

        loan l=new loan();
        l.execute(id);

    }
    public class loan extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("loan");
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
                    String intrest  = jos.getString("intrest");
                    String duration = jos.getString("duration");
                    String bank  = jos.getString("bank");
                    String phone = jos.getString("phone");
                    String email  = jos.getString("email");
                    String link = jos.getString("link");
                    Beanloan bb=new Beanloan();
                    bb.setName(name);
                    bb.setAmount(amount);
                    bb.setIntrest(intrest);
                    bb.setDuration(duration);
                    bb.setBank(bank);
                    bb.setPhone(phone);
                    bb.setEmail(email);
                    bb.setLink(link);
                    blist.add(bb);
                }
                adapt=new Adapterloan(blist,LoanActivity.this);
                recycler.setLayoutManager(new LinearLayoutManager(LoanActivity.this));
                recycler.setAdapter(adapt);
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
