package com.example.sree.outlaymanagement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sree on 11/18/2018.
 */


public class Adapterloan extends RecyclerView.Adapter<Adapterloan.MyViewHolder> {

    List<Beanloan> bpp = null;
    Context context;

    public Adapterloan(List<Beanloan> bpp, Context applicationContext) {
        this.bpp = bpp;
        context = applicationContext;

    }


    @Override
    public Adapterloan.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleloan, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(Adapterloan.MyViewHolder holder, int position) {
        Beanloan B = bpp.get(position);
        holder.name.setText(B.getName());
        holder.amount.setText(B.getAmount());
        holder.intrest.setText(B.getIntrest());
        holder.duration.setText(B.getDuration());
        holder.bank.setText(B.getBank());
        holder.phone.setText(B.getPhone());
        holder.email.setText(B.getEmail());
        holder.link.setText(B.getLink());
    }

    @Override
    public int getItemCount() {
        return bpp.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView amount,intrest,duration,bank,phone,email,link;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtname);
            itemView.setOnClickListener(this);
            amount = itemView.findViewById(R.id.txtamount);
            itemView.setOnClickListener(this);
            intrest = itemView.findViewById(R.id.txtintrest);
            itemView.setOnClickListener(this);
            duration = itemView.findViewById(R.id.txtduration);
            itemView.setOnClickListener(this);
            bank = itemView.findViewById(R.id.txtbank);
            itemView.setOnClickListener(this);
            phone = itemView.findViewById(R.id.txtphone);
            itemView.setOnClickListener(this);
            email = itemView.findViewById(R.id.txtemail);
            itemView.setOnClickListener(this);
            link = itemView.findViewById(R.id.txtlink);
            itemView.setOnClickListener(this);



        }


        @Override
        public void onClick(View view) {

        }
    }
}

