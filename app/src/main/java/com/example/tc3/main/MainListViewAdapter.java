package com.example.tc3.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tc3android.R;

import java.util.List;

public class MainListViewAdapter extends BaseAdapter {

    private Activity activity;
    private List<Item> itemList;
    private LayoutInflater mInflater;
    private ViewHolder viewHolder;

    public MainListViewAdapter(Activity activity, List<Item> itemList) {
        this.activity = activity;
        this.itemList = itemList;
        this.mInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_main,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(itemList.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

}
