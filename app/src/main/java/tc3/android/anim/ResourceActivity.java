package tc3.android.anim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import tc3.android.R;
import tc3.android.common.Item;
import tc3.android.common.ItemListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResourceActivity extends AppCompatActivity {

    private List<Item> itemList;
    private ItemListAdapter adapter;
    @BindView(R.id.lvMain)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        itemList = new ArrayList<>();
        itemList.add(new Item("属性动画",ViewAnimationActivity.class));
        itemList.add(new Item("视图动画-补间",FrameAnimationActivity.class));
        itemList.add(new Item("视图动画-帧", FrameAnimationActivity.class));
        itemList.add(new Item("颜色状态列表",ColorStateListActivity.class));
        itemList.add(new Item("可绘制对象-drawable",DrawableActivity.class));
        adapter = new ItemListAdapter(this,itemList);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ResourceActivity.this, itemList.get(position).getClass()));
            }
        });
    }

}
