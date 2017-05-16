package com.akexorcist.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akexorcist.myapplication.model.NormalItem;
import com.akexorcist.myapplication.model.Product;
import com.akexorcist.myapplication.model.RecommendItem;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_PRODUCT = "extra_product";
    private RecyclerView rvContent;
    private ContentAdapter contentAdapter;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentAdapter = new ContentAdapter(getSupportFragmentManager());
        contentAdapter.setContentListener(contentListener);
        rvContent = (RecyclerView) findViewById(R.id.rv_content);
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(contentAdapter);

        if (savedInstanceState == null) {
            init();
        }
    }

    private void init() {
        updateProduct(mockProduct());
    }

    private void updateProduct(Product product) {
        this.product = product;
        contentAdapter.setProduct(product);
        contentAdapter.notifyDataSetChanged();
    }

    private ContentAdapter.ContentListener contentListener = new ContentAdapter.ContentListener() {
        @Override
        public void onRecommendItemPositionChange(int position) {
            if (product != null) {
                product.setCurrentRecommendItemPosition(position);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_PRODUCT, product);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Product product = savedInstanceState.getParcelable(EXTRA_PRODUCT);
        updateProduct(product);
    }

    private Product mockProduct() {
        Product product = new Product();
        List<RecommendItem> recommendItemList = Arrays.asList(
                new RecommendItem("www.example.com", "Recommend 1", "1000"),
                new RecommendItem("www.example.com", "Recommend 2", "2000"),
                new RecommendItem("www.example.com", "Recommend 3", "3000"),
                new RecommendItem("www.example.com", "Recommend 4", "4000"),
                new RecommendItem("www.example.com", "Recommend 5", "5000"),
                new RecommendItem("www.example.com", "Recommend 6", "6000"),
                new RecommendItem("www.example.com", "Recommend 7", "7000"),
                new RecommendItem("www.example.com", "Recommend 8", "8000"),
                new RecommendItem("www.example.com", "Recommend 9", "9000")
        );
        List<NormalItem> normalItemList = Arrays.asList(
                new NormalItem("www.example.com", "Normal 1", "1000"),
                new NormalItem("www.example.com", "Normal 2", "2000"),
                new NormalItem("www.example.com", "Normal 3", "3000"),
                new NormalItem("www.example.com", "Normal 4", "4000"),
                new NormalItem("www.example.com", "Normal 5", "5000"),
                new NormalItem("www.example.com", "Normal 6", "6000"),
                new NormalItem("www.example.com", "Normal 7", "7000"),
                new NormalItem("www.example.com", "Normal 8", "8000"),
                new NormalItem("www.example.com", "Normal 9", "9000"),
                new NormalItem("www.example.com", "Normal 10", "10000"),
                new NormalItem("www.example.com", "Normal 11", "11000"),
                new NormalItem("www.example.com", "Normal 12", "12000"),
                new NormalItem("www.example.com", "Normal 13", "13000"),
                new NormalItem("www.example.com", "Normal 14", "14000"),
                new NormalItem("www.example.com", "Normal 15", "15000"),
                new NormalItem("www.example.com", "Normal 16", "16000"),
                new NormalItem("www.example.com", "Normal 17", "17000"),
                new NormalItem("www.example.com", "Normal 18", "18000"),
                new NormalItem("www.example.com", "Normal 19", "19000")
        );
        product.setRecommendItemList(recommendItemList);
        product.setNormalItemList(normalItemList);
        return product;
    }
}
