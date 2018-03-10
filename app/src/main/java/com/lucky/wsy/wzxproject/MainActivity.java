package com.lucky.wsy.wzxproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.lucky.wsy.wzxproject.activity.LabelViewActivity;
import com.lucky.wsy.wzxproject.activity.NumberProgressBarActivity;
import com.lucky.wsy.wzxproject.activity.ProgressBarActivity;
import com.lucky.wsy.wzxproject.activity.ShineButtonActivity;
import com.lucky.wsy.wzxproject.activity.SweetAlertDialogActivity;
import com.lucky.wsy.wzxproject.adapter.MainRecyclerAdapter;
import com.lucky.wsy.wzxproject.bean.MainData;
import com.lucky.wsy.wzxproject.activity.MeiTuanListViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MainRecyclerAdapter mainRecyclerAdapter;
    private List<MainData> mainDataList;
    private MainData mainData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        initData();
        mainRecyclerAdapter = new MainRecyclerAdapter(mainDataList, this.getLayoutInflater());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setAdapter(mainRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mainRecyclerAdapter.setOnItemClickListener(new MainRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, SweetAlertDialogActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, LabelViewActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ShineButtonActivity.class));
                        break;

                    case 3:
                        startActivity(new Intent(MainActivity.this, MeiTuanListViewActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ProgressBarActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, NumberProgressBarActivity.class));
                        break;
                }
            }
        });
        recyclerView.setAdapter(mainRecyclerAdapter);
    }

    private void initData() {
        mainDataList = new ArrayList<>();
        mainData = new MainData();
        mainData.setId("1");
        mainData.setName("SweetAlertDialog");
        mainDataList.add(mainData);

        mainData = new MainData();
        mainData.setId("2");
        mainData.setName("LabelView");
        mainDataList.add(mainData);

        mainData = new MainData();
        mainData.setId("3");
        mainData.setName("ShineButton");
        mainDataList.add(mainData);

        mainData = new MainData();
        mainData.setId("4");
        mainData.setName("MeiTuanListView");
        mainDataList.add(mainData);

        mainData = new MainData();
        mainData.setId("5");
        mainData.setName("ProgressBar");
        mainDataList.add(mainData);

        mainData = new MainData();
        mainData.setId("6");
        mainData.setName("NumberProgressBar");
        mainDataList.add(mainData);


    }
}
