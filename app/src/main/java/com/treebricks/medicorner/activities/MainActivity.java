package com.treebricks.medicorner.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.adapters.AdsAdapter;
import com.treebricks.medicorner.adapters.CategoriesAdapter;
import com.treebricks.medicorner.adapters.DealsAdapter;
import com.treebricks.medicorner.adapters.ProductGridAdapter;
import com.treebricks.medicorner.model.Ads;
import com.treebricks.medicorner.model.Category;
import com.treebricks.medicorner.model.Deal;
import com.treebricks.medicorner.model.Product;
import com.treebricks.medicorner.presenters.MainPresenter;
import com.treebricks.medicorner.views.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private RecyclerView rvHeaderAds;
    private RecyclerView rvCategories;
    private RecyclerView rvAfterCategoryAds;
    private RecyclerView rvDeals;
    private RecyclerView rvHotSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCategoryMore = findViewById(R.id.tv_category_more);
        TextView tvDealsMore = findViewById(R.id.tv_deal_more);

        rvHeaderAds = findViewById(R.id.rv_header_ads);
        rvCategories = findViewById(R.id.rv_categories);
        rvDeals = findViewById(R.id.rv_deals);
        rvAfterCategoryAds = findViewById(R.id.rv_after_category_ads);
        rvHotSeller = findViewById(R.id.rv_product_grid);

        rvHeaderAds.setLayoutManager(getHorizontalLayoutManager());
        rvCategories.setLayoutManager(getHorizontalLayoutManager());
        rvAfterCategoryAds.setLayoutManager(getHorizontalLayoutManager());
        rvDeals.setLayoutManager(getHorizontalLayoutManager());
        rvHotSeller.setLayoutManager(getHorizontalLayoutManager());

        mainPresenter = new MainPresenter(this);
        mainPresenter.initPresenter();

        tvCategoryMore.setOnClickListener(view -> mainPresenter.onMoreCategoryClick());
        tvDealsMore.setOnClickListener(view -> mainPresenter.onMoreDealClicked());
    }

    @NonNull
    private LinearLayoutManager getHorizontalLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    }

    @Override
    public void populateHeadersAdsRecyclerView(List<Ads> headerAds) {
        rvHeaderAds.setAdapter(new AdsAdapter(headerAds, mainPresenter::onItemClicked));
    }

    @Override
    public void populateCategoriesRecyclerView(List<Category> categories) {
        rvCategories.setAdapter(new CategoriesAdapter(categories, mainPresenter::onItemClicked));
    }

    @Override
    public void populateAfterCategoryAdsRecyclerView(List<Ads> afterCategoryAds) {
        rvAfterCategoryAds.setAdapter(new AdsAdapter(afterCategoryAds, mainPresenter::onItemClicked));
    }

    @Override
    public void populateDealsRecyclerView(List<Deal> deals) {
        rvDeals.setAdapter(new DealsAdapter(deals, mainPresenter::onItemClicked));
    }

    @Override
    public void populateHotSellerRecyclerView(List<Product> products) {
        for (Product product : products) {
            Log.d("Price", product.getCurrentPrice());
        }
        rvHotSeller.setAdapter(new ProductGridAdapter(products, mainPresenter::onItemClicked));
    }

    @Override
    public void onMoreCategoryClicked() {
        Toast.makeText(this, "More Category Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMoreDealClicked() {
        Toast.makeText(this, "More Deal Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
