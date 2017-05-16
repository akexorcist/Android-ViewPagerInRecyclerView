package com.akexorcist.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.akexorcist.myapplication.model.RecommendItem;

import java.util.List;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class RecommendAdapter extends FragmentStatePagerAdapter {
    private List<RecommendItem> recommendItemList;

    public RecommendAdapter(FragmentManager fm, List<RecommendItem> recommendItemList) {
        super(fm);
        this.recommendItemList = recommendItemList;
    }

    @Override
    public Fragment getItem(int position) {
        return RecommendFragment.newInstance(recommendItemList.get(position));
    }

    @Override
    public int getCount() {
        return recommendItemList != null ? recommendItemList.size() : 0;
    }
}
