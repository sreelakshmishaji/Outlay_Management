package com.example.sree.outlaymanagement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sree on 11/19/2018.
 */

public class Adapterinsurance extends RecyclerView.Adapter<Adapterinsurance.MyViewHolder> {

    List<Beaninsurance> bpp;
    Context context;

    public Adapterinsurance(List<Beaninsurance> bpp, Context applicationContext) {
        this.bpp = bpp;
        context = applicationContext;
    }


    @Override
    public Adapterinsurance.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleinsurance, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(Adapterinsurance.MyViewHolder holder, int position) {
        Beaninsurance B = bpp.get(position);
        holder.nam.setText(B.getName1());
        holder.amt.setText(B.getAmount1());
        holder.dut.setText(B.getDuration());
        holder.comp.setText(B.getCompany());
        holder.phn.setText(B.getPhone());
        holder.mail.setText(B.getEmail());
    }

    @Override
    public int getItemCount() {
        return bpp.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nam, amt, dut, comp, phn, mail;

        public MyViewHolder(View itemView) {
            super(itemView);
            nam = itemView.findViewById(R.id.txtname);
            itemView.setOnClickListener(this);
            amt = itemView.findViewById(R.id.txtamount);
            itemView.setOnClickListener(this);
            dut = itemView.findViewById(R.id.txtduration);
            itemView.setOnClickListener(this);
            comp = itemView.findViewById(R.id.txtcompany);
            itemView.setOnClickListener(this);
            phn = itemView.findViewById(R.id.txtphone);
            itemView.setOnClickListener(this);
            mail = itemView.findViewById(R.id.txtemail);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {

        }
    }
}