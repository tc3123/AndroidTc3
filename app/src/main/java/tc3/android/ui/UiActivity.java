package tc3.android.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tc3.android.R;
import tc3.android.common.BaseActivity;
import tc3.android.common.Item;

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

class RvAdapter extends RecyclerView.Adapter<RvViewHolder> {
    private List<Item> list;
    private Context context;

    public RvAdapter(Context context, List<Item> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ui, parent, false));//TODO 必须是false
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        Item item = list.get(position);
        holder.tvContent.setText(item.getTitle());
        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, item.getActivityClass()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
class RvViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvContent)
    public TextView tvContent;

    public RvViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
