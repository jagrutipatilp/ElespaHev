package com.example.a.ui.notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a.Adapter.notificationAdapter;
import com.example.a.Modal.notificationModel;
import com.example.a.R;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private RecyclerView recyclerView;
    private notificationAdapter adapter;
    private ArrayList<notificationModel> notificationList;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.notificationrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationList = new ArrayList<>();
        notificationList.add(new notificationModel("Notification 1", "10"));
        notificationList.add(new notificationModel("Notification 2", "20"));
        notificationList.add(new notificationModel("Locked","10"));
        notificationList.add(new notificationModel("Parking","20"));
        notificationList.add(new notificationModel("on Trip","15"));
        notificationList.add(new notificationModel("charging","05"));
        notificationList.add(new notificationModel("Req. Refulling","12"));
        notificationList.add(new notificationModel("Parking","20"));
        notificationList.add(new notificationModel("on Trip","15"));
        notificationList.add(new notificationModel("charging","05"));
        notificationList.add(new notificationModel("Req. Refulling","12"));
        adapter = new notificationAdapter(notificationList, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}