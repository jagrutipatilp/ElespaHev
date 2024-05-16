package com.example.a;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a.Adapter.shopAdapter;
import com.example.a.Interface.selectiListner;
import com.example.a.Modal.shopModal;

import java.util.ArrayList;

public class ShopFragment extends Fragment implements selectiListner {
    RecyclerView shoprv;
    ArrayList<shopModal>list;
    shopAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        shoprv = view.findViewById(R.id.shoprv);
        list = new ArrayList<>();
        list.add(new shopModal("Engine","Lorem Ipsum is simply dummy",R.drawable.img1));
        list.add(new shopModal("Wheel"," text of the printing and typesetting industry",R.drawable.img2));
        list.add(new shopModal("Hybrid Kit","Lorem Ipsum has been the industry's",R.drawable.img1));
        list.add(new shopModal("cooloing system"," standard dummy text ever since the 1500s",R.drawable.img3));
        list.add(new shopModal("Engine","Jai Hind vande matram jai maharastra",R.drawable.img1));
        adapter =new shopAdapter(list,getContext(),this);
        shoprv.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        shoprv.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onItemClicked(shopModal sm) {
        Intent intent =new Intent(getActivity(), Product.class);
        startActivity(intent);
    }
}