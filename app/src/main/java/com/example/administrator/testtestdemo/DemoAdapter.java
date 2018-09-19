package com.example.administrator.testtestdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/3.
 * User: Nick
 * Date: 2016/11/3
 * Email: 305812387@qq.com
 * Project: AlipayDemo
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHold> {
    private int max;
    private LayoutInflater inflater;

    public DemoAdapter(int max) {
        this.max = max;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View item = inflater.inflate(R.layout.layout_item, parent, false);
        return new ViewHold(item);
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {
        holder.text.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return max;
    }

    public static class ViewHold extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHold(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item);
        }
    }

}
