package tc3.android.main;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import tc3.android.anim.AnimActivity;
import tc3.android.component.IntentActivity;
import tc3.android.hardware.HardWareActivity;
import tc3.android.ui.UiActivity;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arr = new String[]{"组件","界面","多媒体","硬件","网络","存储","Intent"};
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0://组件
                break;
            case 1://界面
                startActivity(new Intent(MainActivity.this, UiActivity.class));
                break;
            case 2://多媒体
                startActivity(new Intent(MainActivity.this, AnimActivity.class));
                break;
            case 3://硬件
                startActivity(new Intent(MainActivity.this, HardWareActivity.class));
                break;
            case 4://网络
                startActivity(new Intent(MainActivity.this, null));
                break;
            case 5://存储
                startActivity(new Intent(MainActivity.this, null));
                break;
            case 6://Intent
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
                break;
        }
    }
}