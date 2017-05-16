package com.akexorcist.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akexorcist.myapplication.holder.NormalItemViewHolder;
import com.akexorcist.myapplication.holder.RecommendItemViewHolder;
import com.akexorcist.myapplication.model.NormalItem;
import com.akexorcist.myapplication.model.Product;
import com.akexorcist.myapplication.model.RecommendItem;

import java.util.List;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_RECOMMEND = 0;
    private static final int TYPE_NORMAL = 1;

    private Product product;
    private FragmentManager fragmentManager;
    private ContentListener contentListener;

    public ContentAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setContentListener(ContentListener contentListener) {
        this.contentListener = contentListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_RECOMMEND) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recommend_item, parent, false);
            return new RecommendItemViewHolder(view);
        } else if (viewType == TYPE_NORMAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_normal_item, parent, false);
            return new NormalItemViewHolder(view);
        }
        throw new NullPointerException("View type doesn't match (" + viewType + ")");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommendItemViewHolder) {
            RecommendItemViewHolder viewHolder = (RecommendItemViewHolder) holder;
            viewHolder.setRecommendItemList(fragmentManager, product.getRecommendItemList());
            viewHolder.setViewPagerCurrentItem(product.getCurrentRecommendItemPosition());
            viewHolder.setViewPageListener(new RecommendItemViewHolder.ViewPageListener() {
                @Override
                public void onPositionChanged(int position) {
                    if (contentListener != null) {
                        contentListener.onRecommendItemPositionChange(position);
                    }
                }
            });

        } else if (holder instanceof NormalItemViewHolder) {
            NormalItemViewHolder viewHolder = (NormalItemViewHolder) holder;
            NormalItem normalItem = product.getNormalItemList().get(position - 1);
            viewHolder.setName(normalItem.getName());
            viewHolder.setPrice(normalItem.getPrice());
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof RecommendItemViewHolder) {
            RecommendItemViewHolder viewHolder = (RecommendItemViewHolder) holder;
            viewHolder.clearViewPagerListener();
        }
    }

    @Override
    public int getItemViewType(int position) {
        List<RecommendItem> recommendItemList = product.getRecommendItemList();
        if (recommendItemList != null && position == 0) {
            return TYPE_RECOMMEND;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        if (product != null) {
            List<RecommendItem> recommendItemList = product.getRecommendItemList();
            List<NormalItem> normalItemList = product.getNormalItemList();
            return (recommendItemList != null ? 1 : 0) +
                    (normalItemList != null ? normalItemList.size() : 0);
        }
        return 0;
    }

    public interface ContentListener {
        void onRecommendItemPositionChange(int position);
    }
}
