package com.example.tc3android.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tc3.anim.ViewAnimationActivity;
import com.example.tc3android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList;
    private MainListViewAdapter adapter;
    @BindView(R.id.lvMain)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        itemList = new ArrayList<>();
        itemList.add(new Item("属性动画"));
        itemList.add(new Item("视图动画-补间"));
        itemList.add(new Item("视图动画-帧"));
        adapter = new MainListViewAdapter(this,itemList);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ViewAnimationActivity.class));
                }
            }
        });
    }




}
