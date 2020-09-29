package tc3.android.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import tc3.android.R;

public class Adpater1 extends RecyclerView.Adapter<Adpater1.ViewHolder>{

    private List<Map<String, String>> list;
    public Adpater1(List<Map<String, String>> list) {
        this.list = list;
    }
    /**
     * 创建视图
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter1, parent, false);
        return  new ViewHolder(itemView);
    }

    /**
     * 视图绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvItem.setText(list.get(position).get("index"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }

    /**
     * 通知 监听者 数据改变
     */
    public void notifyMethod(){
//        notifyItemChanged();
        notifyDataSetChanged();
    }
}
