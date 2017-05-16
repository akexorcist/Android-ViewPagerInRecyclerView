package com.akexorcist.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class Product implements Parcelable {
    private int currentRecommendItemPosition = 0;
    private List<NormalItem> normalItemList;
    private List<RecommendItem> recommendItemList;

    public Product() {
    }

    public Product(List<NormalItem> normalItemList, List<RecommendItem> recommendItemList) {
        this.normalItemList = normalItemList;
        this.recommendItemList = recommendItemList;
    }

    public int getCurrentRecommendItemPosition() {
        return currentRecommendItemPosition;
    }

    public void setCurrentRecommendItemPosition(int position) {
        this.currentRecommendItemPosition = position;
    }

    public List<NormalItem> getNormalItemList() {
        return normalItemList;
    }

    public void setNormalItemList(List<NormalItem> normalItemList) {
        this.normalItemList = normalItemList;
    }

    public List<RecommendItem> getRecommendItemList() {
        return recommendItemList;
    }

    public void setRecommendItemList(List<RecommendItem> recommendItemList) {
        this.recommendItemList = recommendItemList;
    }

    protected Product(Parcel in) {
        currentRecommendItemPosition = in.readInt();
        normalItemList = in.createTypedArrayList(NormalItem.CREATOR);
        recommendItemList = in.createTypedArrayList(RecommendItem.CREATOR);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(currentRecommendItemPosition);
        dest.writeTypedList(normalItemList);
        dest.writeTypedList(recommendItemList);
    }
}
