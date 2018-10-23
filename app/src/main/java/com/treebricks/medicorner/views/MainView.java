package com.treebricks.medicorner.views;

import com.treebricks.medicorner.model.Ads;
import com.treebricks.medicorner.model.Category;
import com.treebricks.medicorner.model.Deal;
import com.treebricks.medicorner.model.Product;

import java.util.List;

public interface MainView {
    void populateHeadersAdsRecyclerView(List<Ads> headerAds);

    void populateCategoriesRecyclerView(List<Category> categories);

    void populateAfterCategoryAdsRecyclerView(List<Ads> afterCategoryAds);

    void populateDealsRecyclerView(List<Deal> deals);

    void populateHotSellerRecyclerView(List<Product> products);

    void onMoreCategoryClicked();

    void onMoreDealClicked();
}
