package tc3.android.hardware;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import tc3.android.R;
import tc3.android.common.BaseActivity;
import tc3.android.common.Item;
import tc3.android.common.RvAdapter;
import tc3.android.ui.RecyclerViewActivity;

public class HardWareActivity extends BaseActivity {
    @BindView(R.id.rvMain)
    RecyclerView rvMain;
    private RvAdapter adapter;
    private List<Item> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_hardware;
    }

    @Override
    protected void initView() {
        list = Arrays.asList(
                new Item("NFC", NfcActivity.class)
        );
        adapter = new RvAdapter(this, list);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEvent() {

    }
}
