package tc3.android.common;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tc3.android.R;

public class RvAdapter extends RecyclerView.Adapter<RvViewHolder> {
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