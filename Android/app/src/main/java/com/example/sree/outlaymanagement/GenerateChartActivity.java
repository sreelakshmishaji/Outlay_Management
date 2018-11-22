package com.example.sree.outlaymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONArray;
import org.json.JSONObject;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
//import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;





public class  GenerateChartActivity extends AppCompatActivity {
    SharedPreferences sh;
    String id;
    String sh_name = "MyData";
    String inc , exp, svngs;
    private PieChart chart;
    private SeekBar seekBarX, seekBarY;
    private TextView tvX, tvY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_chart);
        sh = getSharedPreferences(sh_name, MODE_PRIVATE);
        id = sh.getString("User_id", " ");

      String startDate= getIntent().getStringExtra("startDate");
      String endDate= getIntent().getStringExtra("endDate");
      String type = getIntent().getStringExtra("type");


    //  if(type.equals("Pie Chart")){
          Toast.makeText(GenerateChartActivity.this, id+"\n"+startDate+"\n"+endDate, Toast.LENGTH_SHORT).show();
          Log.d("alliswell",id+"\n"+startDate+"\n"+endDate);
          chart chr= new chart();
          chr.execute(id,startDate,endDate);
      // }

    }

    private class chart extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller wc = new WebServiceCaller();
            wc.setSoapObject("graph");
            wc.addProperty("Personid", strings[0]);
            wc.addProperty("Fromdate", strings[1]);
            wc.addProperty("Todate", strings[2]);
            wc.callWebService();
            return wc.getResponse();
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d ("all_is_well",s);
            try {
                JSONArray j=new JSONArray(s);
                JSONObject jo=j.getJSONObject(0);
                 inc = jo.getString("income");
                 exp = jo.getString("expense");
                 svngs = jo.getString("savings");
                Log.d ("all_is_well_inc",inc);
                Log.d ("all_is_well_exp",exp);
                Log.d ("all_is_well_svngs",svngs);
Intent i = new Intent(GenerateChartActivity.this,Chart.class);
i.putExtra("inc",inc);
i.putExtra("exp",exp);
i.putExtra("svngs",svngs);
Toast.makeText(GenerateChartActivity.this,"intent",Toast.LENGTH_SHORT).show();
startActivity(i);
            }
            catch (Exception e) {
                e.printStackTrace();

            }

        }
    }
}
