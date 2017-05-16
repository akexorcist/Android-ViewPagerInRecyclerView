package com.akexorcist.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akexorcist.myapplication.model.RecommendItem;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class RecommendFragment extends Fragment {
    private static final String EXTRA_ITEM = "extra_item";

    private TextView tvName;
    private TextView tvPrice;

    private RecommendItem recommendItem;

    public static RecommendFragment newInstance(RecommendItem recommendItem) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ITEM, recommendItem);
        fragment.setArguments(bundle);
        return fragment;
    }

    public RecommendFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null && getArguments() != null) {
            recommendItem = getArguments().getParcelable(EXTRA_ITEM);
        } else if (savedInstanceState != null) {
            recommendItem = savedInstanceState.getParcelable(EXTRA_ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvPrice = (TextView) view.findViewById(R.id.tv_price);

        if (recommendItem != null) {
            tvName.setText(recommendItem.getName());
            tvPrice.setText(recommendItem.getPrice());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_ITEM, recommendItem);
    }
}
