package com.example.sree.outlaymanagement;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sree on 11/7/2018.
 */

public class Adapterexpense extends RecyclerView.Adapter<Adapterexpense.MyViewHolder> {
    List<Beanexpense> bpp;
    Context context;
    public Adapterexpense(List<Beanexpense> bpp, Context applicationContext) {
        this.bpp = bpp;
        context = applicationContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleexpensetype,parent,false);
            return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Beanexpense B=bpp.get(position);
        String message="Have you purchased something from "+B.getName()+"on "+B.getDate()+"for RS. "+B.getAmount()+"?";
        holder.name.setText(message);

    }

    @Override
    public int getItemCount() {
        return bpp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        EditText expense;
        Button edit;
        Button cancel;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtexpensenot);
            itemView.setOnClickListener(this);
            expense=itemView.findViewById(R.id.edtexpensee);
            itemView.setOnClickListener(this);
            edit=itemView.findViewById(R.id.btndone);
            edit.setOnClickListener(this);
            cancel=itemView.findViewById(R.id.btncncl11);
            cancel.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(view==edit)
            {
                int a =getAdapterPosition();
                Beanexpense bb = bpp.get(a);
                String id= bb.getExpid();
                String upd=expense.getText().toString();
                Toast.makeText(context, upd+"\n"+id, Toast.LENGTH_SHORT).show();
                updateExp ue = new  updateExp();
                ue.execute(id,upd);
            }
            else if (view == cancel) {
                expense.setText("");



            }

        }
        private class updateExp extends AsyncTask<String,String,String>{
            @Override
            protected String doInBackground(String... strings) {
                WebServiceCaller wc = new WebServiceCaller();
                wc.setSoapObject("updatenameexp");
                wc.addProperty("id", strings[0]);
                wc.addProperty("text", strings[1]);
                wc.callWebService();
                return wc.getResponse();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s.equals("true")) {
                    Toast.makeText(context, "Sucessfully updated", Toast.LENGTH_SHORT).show();
                }
                   else

                    Toast.makeText(context, "Updation Failed", Toast.LENGTH_SHORT).show();
                }


            }
        }
}
