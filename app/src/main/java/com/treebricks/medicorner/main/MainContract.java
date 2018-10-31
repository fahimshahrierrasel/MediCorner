package com.treebricks.medicorner.main;

import com.treebricks.medicorner.BasePresenter;
import com.treebricks.medicorner.BaseView;
import com.treebricks.medicorner.data.model.Ads;
import com.treebricks.medicorner.data.model.Category;
import com.treebricks.medicorner.data.model.Deal;
import com.treebricks.medicorner.data.model.Product;

import java.util.List;

public interface MainContract {
    interface View extends BaseView<Presenter> {
        void populateHeadersAdsRecyclerView(List<Ads> headerAds);

        void populateCategoriesRecyclerView(List<Category> categories);

        void populateAfterCategoryAdsRecyclerView(List<Ads> afterCategoryAds);

        void populateDealsRecyclerView(List<Deal> deals);

        void populateHotSellerRecyclerView(List<Product> products);

        void onMoreCategoryClicked();

        void onMoreDealClicked();
    }

    interface Presenter extends BasePresenter {
        void onItemClicked(Ads ads);

        void onItemClicked(Category category);

        void onItemClicked(Deal deal);

        void onItemClicked(Product product);

        void onDestroy();

        void onMoreCategoryClick();

        void onMoreDealClicked();
    }
}
