package com.example.sree.outlaymanagement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class SMSReceiver extends BroadcastReceiver  {
  //  String locationPassword,calllogPassword,msgPassword;
    Context context;
    String trans_amt="",type="",t_date="",u_id="";
int locationFlag=0;
String specialLocation="";
    String loc;
    String sh_name = "MyData";
    String id="";
    Geocoder geocoder;
    List<Address> addresses;


    LocationManager locationManager;
    String lattitude;
    String longitude;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        SmsManager smsManager=SmsManager.getDefault();

        SharedPreferences sh=context.getSharedPreferences("MyData",MODE_PRIVATE);
        u_id=sh.getString("User_id","");

        Log.d("Alliswell","sms");
        Toast.makeText(context, "message received", Toast.LENGTH_LONG).show();
        Bundle bundle=intent.getExtras();

        SmsMessage[] msgs= null;
        String str ="";
        String sendernumber=null;
        if (bundle!=null)
        {
            Object[] pdusO=(Object[])bundle.get("pdus");
            msgs = new SmsMessage[pdusO.length];
            String message="";
            for (int i=0;i<msgs.length;i++)
            {
                SmsMessage sms=SmsMessage.createFromPdu((byte[])pdusO[i]);
                sendernumber=sms.getOriginatingAddress();
                message=sms.getMessageBody().toString();
                // Toast.makeText(context,"From"+sendernumber+"message"+message, Toast.LENGTH_LONG).show();

            }
//            if (message.equals(locationPassword)) {
//                Log.d("Toast", "Password Matched");
//                Toast.makeText(context, "Password Matched", Toast.LENGTH_SHORT).show();
//                // Toast.makeText(context, "From" + sendernumber + "message" + message, Toast.LENGTH_LONG).show();
//                String messageToSend = "";
//                String number = sendernumber;
//
//                SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
//            }
                     if(sendernumber.equals("+917510823588")||sendernumber.equals("+918137040884")) {
                        Log.d("Alliswell","Messege From Bank\n"+message);
                    String msg=message;

                         String amount[]=null;
                    if(msg.contains("Rs. ")) {
                         amount = msg.split("Rs. ");
                        int a = 0, b = 0;
                        String[] substrings = msg.split("[^A-Z]+");
                        for (String s : substrings) {
                            if (!s.isEmpty() && s.length() > 1) {
                                b++;
                                //  System.out.println(s);
                                if (a == 0) {
                                    a++;
                                    type = type + s + " ";
                                }
                                if (b == a + 1) {
                                    type = type + s + " ";

                                }
                            }
                        }
                    }
                         if(msg.contains("Rs ")) {
                             amount = msg.split("Rs ");
                             int a = 0, b = 0;
                             String[] substrings = msg.split("[^A-Z]+");
                             for (String s : substrings) {
                                 if (!s.isEmpty() && s.length() > 1) {
                                     b++;
                                     //  System.out.println(s);
                                     if (a == 0) {
                                         a++;
                                         type = type + s + " ";
                                     }
                                     if (b == a + 1) {
                                         type = type + s + " ";

                                     }
                                 }
                             }
                         }
                         String amt[] = amount[1].split(" ");
                         trans_amt=amt[0];
                         if(msg.contains(" on ")) {

                             String date2[] = msg.split(" on ");
                             String date1[] = date2[1].split(" ");
                             t_date = date1[0];
                         }
                         else{
                             Date dt = new Date();
                                t_date= new SimpleDateFormat("yyyy-MM-dd").format(dt);

                         }
                if(type.equals("")){

                    type=getLocation();

                }
                         Log.d("Alliswell","Date  : "+t_date);
                         Log.d("Alliswell","Amount  : "+trans_amt);
                         Log.d("Alliswell","Expence Type : "+type);

                        insertExpence ie = new insertExpence();
                        ie.execute(u_id,type,trans_amt,t_date);
             }

        }

    }

    private class insertExpence extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings) {
            WebServiceCaller w = new WebServiceCaller();
            w.setSoapObject("messagetracking");
            w.addProperty("Personid", strings[0]);
            w.addProperty("Extype", strings[1]);
            w.addProperty("Amount", strings[2]);
            w.addProperty("Date",strings[3]);

            w.callWebService();
            return w.getResponse();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
        }
    }

    public String getLocation() {

        try {
            gpstrack j=new gpstrack(context);

            Location loc;
            loc = j.getLocation();

            double a=loc.getLatitude();
            double b=loc.getLongitude();
            String lat=Double.toString(a);
            String longit=Double.toString(b);
//                Log.d("longitude",longit);
//                Log.d("latitude",lat);



            geocoder = new Geocoder(context, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(a,b, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            } catch (IOException e) {
                e.printStackTrace();
            }

            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state1 = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            SharedPreferences sh= context.getSharedPreferences("PHONEIMEI",MODE_PRIVATE);
            String id=sh.getString("id","");
            Log.d("adressline",address);


            specialLocation="City:"+address+city;

        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return specialLocation;
    }

}

