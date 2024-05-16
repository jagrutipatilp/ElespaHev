package com.example.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a.Adapter.ViewPagerAAdapter;

public class Product extends AppCompatActivity {
    ViewPager mViewPager;
    Button orderbtn;
    ViewPagerAAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        orderbtn = findViewById(R.id.order);

        int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img1,};

        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAAdapter(Product.this, images);
        mViewPager.setAdapter(mViewPagerAdapter);

    }
}