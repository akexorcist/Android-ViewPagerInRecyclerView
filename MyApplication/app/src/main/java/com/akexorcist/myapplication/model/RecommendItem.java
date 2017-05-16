package com.akexorcist.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Akexorcist on 5/16/2017 AD.
 */

public class RecommendItem implements Parcelable {
    private String url;
    private String name;
    private String price;

    public RecommendItem() {
    }

    public RecommendItem(String url, String name, String price) {
        this.url = url;
        this.name = name;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    protected RecommendItem(Parcel in) {
        url = in.readString();
        name = in.readString();
        price = in.readString();
    }

    public static final Creator<RecommendItem> CREATOR = new Creator<RecommendItem>() {
        @Override
        public RecommendItem createFromParcel(Parcel in) {
            return new RecommendItem(in);
        }

        @Override
        public RecommendItem[] newArray(int size) {
            return new RecommendItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(name);
        dest.writeString(price);
    }
}
