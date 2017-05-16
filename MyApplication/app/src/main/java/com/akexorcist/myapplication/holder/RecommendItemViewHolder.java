package com.akexorcist.myapplication.holder;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.akexorcist.myapplication.R;
import com.akexorcist.myapplication.RecommendAdapter;
import com.akexorcist.myapplication.model.RecommendItem;

import java.util.List;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class RecommendItemViewHolder extends RecyclerView.ViewHolder {
    private ViewPager vpContent;

    public RecommendItemViewHolder(View itemView) {
        super(itemView);
        vpContent = (ViewPager) itemView.findViewById(R.id.vp_content);
    }

    public void setRecommendItemList(FragmentManager fragmentManager, List<RecommendItem> recommendItemList) {
        vpContent.setAdapter(new RecommendAdapter(fragmentManager, recommendItemList));
    }

    public void setViewPagerCurrentItem(int position) {
        vpContent.setCurrentItem(position, false);
    }

    public void setViewPageListener(final ViewPageListener viewPageListener) {
        if (viewPageListener != null) {
            vpContent.addOnPageChangeListener(onPageChange(viewPageListener));
        }
    }

    public void clearViewPagerListener() {
        vpContent.clearOnPageChangeListeners();
    }

    private ViewPager.OnPageChangeListener onPageChange(final ViewPageListener viewPageListener) {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPageListener.onPositionChanged(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    public interface ViewPageListener {
        void onPositionChanged(int position);
    }
}
