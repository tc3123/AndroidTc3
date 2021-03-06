package tc3.android.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import tc3.android.R;
import tc3.android.common.BaseActivity;
import tc3.android.common.Item;
import tc3.android.common.RvAdapter;

public class UiActivity extends BaseActivity {

    @BindView(R.id.rvMain)
    RecyclerView rvMain;
    private RvAdapter adapter;
    private List<Item> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_ui;
    }

    @Override
    protected void initView() {
        list = Arrays.asList(
                new Item("RecyclerView", RecyclerViewActivity.class)
        );
        adapter = new RvAdapter(this, list);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEvent() {

    }

}



