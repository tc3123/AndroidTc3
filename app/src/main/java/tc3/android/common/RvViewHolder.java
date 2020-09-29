package tc3.android.common;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tc3.android.R;


class RvViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvContent)
    public TextView tvContent;

    public RvViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}