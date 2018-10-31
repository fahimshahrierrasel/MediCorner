package com.treebricks.medicorner.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.adapters.AdsAdapter;
import com.treebricks.medicorner.adapters.CategoriesAdapter;
import com.treebricks.medicorner.adapters.DealsAdapter;
import com.treebricks.medicorner.adapters.ProductGridAdapter;
import com.treebricks.medicorner.data.model.Ads;
import com.treebricks.medicorner.data.model.Category;
import com.treebricks.medicorner.data.model.Deal;
import com.treebricks.medicorner.data.model.Product;

import java.util.List;

public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mainPresenter;
    private RecyclerView rvHeaderAds;
    private RecyclerView rvCategories;
    private RecyclerView rvAfterCategoryAds;
    private RecyclerView rvDeals;
    private RecyclerView rvHotSeller;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fagment_main, container, false);

        rvHeaderAds = root.findViewById(R.id.rv_header_ads);
        rvCategories = root.findViewById(R.id.rv_categories);
        rvDeals = root.findViewById(R.id.rv_deals);
        rvAfterCategoryAds = root.findViewById(R.id.rv_after_category_ads);
        rvHotSeller = root.findViewById(R.id.rv_product_grid);

        rvHeaderAds.setLayoutManager(getHorizontalLayoutManager());
        rvCategories.setLayoutManager(getHorizontalLayoutManager());
        rvAfterCategoryAds.setLayoutManager(getHorizontalLayoutManager());
        rvDeals.setLayoutManager(getHorizontalLayoutManager());
        rvHotSeller.setLayoutManager(getHorizontalLayoutManager());

        TextView tvCategoryMore = root.findViewById(R.id.tv_category_more);
        TextView tvDealsMore = root.findViewById(R.id.tv_deal_more);

        tvCategoryMore.setOnClickListener(view -> mainPresenter.onMoreCategoryClick());
        tvDealsMore.setOnClickListener(view -> mainPresenter.onMoreDealClicked());

        return root;
    }

    @NonNull
    private LinearLayoutManager getHorizontalLayoutManager() {
        return new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
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
        Toast.makeText(getContext(), "More Category Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMoreDealClicked() {
        Toast.makeText(getContext(), "More Deal Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.start();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }
}
