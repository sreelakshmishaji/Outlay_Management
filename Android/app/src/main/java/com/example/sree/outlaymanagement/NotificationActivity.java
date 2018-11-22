package com.example.sree.outlaymanagement;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    AdapterNotify adapt;
    Adapterexpense adapterexpense;
    List<BeanNotify> blist;
    List<Beanexpense> belist;
    RecyclerView recycler;
    RecyclerView expnotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");
        notification n=new notification();
        n.execute(id);
        blist=new ArrayList<>();


        belist=new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.recycler);
        expnotify=(RecyclerView)findViewById(R.id.expense);
        expensenotify exp = new expensenotify();
        exp.execute(id);
    }
    private class notification extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("notification");
            w.addProperty("Personid", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(NotificationActivity.this, ""+s, Toast.LENGTH_SHORT).show();

            JSONArray ji= null;
            try {
                ji = new JSONArray(s);
                for(int i=0;i<ji.length();i++){
                    JSONObject jos= ji.getJSONObject(i);
                    String name  = jos.getString("Name");
                    String date = jos.getString("Date");
                    BeanNotify bb=new BeanNotify();
                    bb.setNotifyname(name);
                    bb.setNotifydate(date);
                    blist.add(bb);
                }
                adapt=new AdapterNotify(blist,NotificationActivity.this);
                recycler.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
                recycler.setAdapter(adapt);
            } catch(JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public class expensenotify extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("notifyexpense");
            w.addProperty("personid", strings[0]);
            w.callWebService();
            return w.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONArray jii=null;
            Log.d("alliswell",s);
            try {
                jii = new JSONArray(s);
                for(int i=0;i<jii.length();i++) {
                    JSONObject joss = jii.getJSONObject(i);
                    String date = joss.getString("Date");
                    String amount = joss.getString("Amount");
                    String id = joss.getString("Id");
                    String name = joss.getString("Name");
                    String person = joss.getString("Person");
                    if(name.contains("City")) {
                        Beanexpense bb = new Beanexpense();
                        bb.setDate(date);
                        bb.setAmount(amount);
                        bb.setExpid(id);
                        bb.setName(name);


                        Log.d("alliswell","city::"+name);
                        belist.add(bb);
                    }
                }
                adapterexpense=new Adapterexpense(belist,NotificationActivity.this);
                expnotify.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
                expnotify.setAdapter(adapterexpense);
            } catch(JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
