package com.example.a.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a.Modal.notificationModel;
import com.example.a.R;

import java.util.ArrayList;

public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.viewHolder>{

    ArrayList<notificationModel> list;
    Context context;

    public notificationAdapter(ArrayList<notificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notificationrv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            notificationModel model = list.get(position);
            holder.notification.setText(model.getNote());
            String str = model.getTime() + " min ago";
            holder.time.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
      TextView notification,time;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            notification = itemView.findViewById(R.id.notificationText);
            time = itemView.findViewById(R.id.notification_time);
        }
    }
}
