package com.example.tc3.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tc3.resource.anim.FrameAnimationActivity;
import com.example.tc3.resource.anim.ViewAnimationActivity;
import com.example.tc3.resource.drawable.DrawableActivity;
import com.example.tc3.resource.state.ColorStateListActivity;
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
        itemList.add(new Item("颜色状态列表"));
        itemList.add(new Item("可绘制对象-drawable"));
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
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, FrameAnimationActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, ColorStateListActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, DrawableActivity.class));
                        break;
                }
            }
        });
    }




}
