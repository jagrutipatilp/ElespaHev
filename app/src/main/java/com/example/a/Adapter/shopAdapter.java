package com.example.a.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a.Interface.selectiListner;
import com.example.a.Modal.shopModal;
import com.example.a.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.viewHolder>  {

    ArrayList<shopModal>list;
    Context context;
   private selectiListner listner;

    public shopAdapter(ArrayList<shopModal> list, Context context, selectiListner listner) {
        this.list = list;
        this.context = context;
        this.listner=listner;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_rv,parent,false);
        return new viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        shopModal modal = list.get(position);
        holder.img.setImageResource(modal.getImage());
        holder.name.setText(modal.getName());
        holder.descr.setText(modal.getDescr());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onItemClicked(list.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name , descr;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.prod_img);
            name= itemView.findViewById(R.id.prod_name);
            descr = itemView.findViewById(R.id.prod_descr);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
