package com.example.sree.outlaymanagement;

/**
 * Created by sree on 10/21/2018.
 */



        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

/**
 * Created by Mariya on 10/11/2018.
 */

public class AdapterNotify extends RecyclerView.Adapter<AdapterNotify.MyViewHolder> {
    List<BeanNotify> bpp=null;
    Context context;

    public AdapterNotify(List<BeanNotify> bpp, Context applicationContext) {
        this.bpp=bpp;
        context=applicationContext;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlenotify,parent,false);
        return new MyViewHolder(itemview);
    }

   

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BeanNotify B=bpp.get(position);
        holder.notifyname.setText(B.getNotifyname());
        holder.notifydate.setText(B.getNotifydate());

    }

    @Override
    public int getItemCount() {
        return bpp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView notifyname;
        TextView notifydate;
        public MyViewHolder(View itemView) {
            super(itemView);
            notifyname=itemView.findViewById(R.id.edtNotify);
            itemView.setOnClickListener(this);
            notifydate=itemView.findViewById(R.id.txtdate);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
//            int a=getAdapterPosition();
//            BeanNotify bp=bpp.get(a);
//            String notific=bp.getProdplanid();
//            String planrate=bp.getPlanrate();
//            String plantyp=bp.getPlantype();
//            String prodid=bp.getProdid();
//            Intent i = new Intent(context, BookingActivity.class);
//            i.putExtra("planid",planid);
//            i.putExtra("planrat",planrate);
//            i.putExtra("plantype",plantyp);
//            i.putExtra("prodid",prodid);
//            i.putExtra("productName",bp.getProductName());
//            context.startActivity(i);


        }
    }
}
