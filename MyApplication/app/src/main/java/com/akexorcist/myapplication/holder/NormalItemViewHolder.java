package com.akexorcist.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.myapplication.R;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class NormalItemViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvPrice;

    public NormalItemViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setPrice(String price) {
        tvPrice.setText(price);
    }
}
