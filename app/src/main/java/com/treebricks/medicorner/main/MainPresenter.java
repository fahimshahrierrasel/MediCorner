package com.treebricks.medicorner.main;

import android.util.Log;

import com.treebricks.medicorner.data.model.Ads;
import com.treebricks.medicorner.data.model.Category;
import com.treebricks.medicorner.data.model.Deal;
import com.treebricks.medicorner.data.model.Product;
import com.treebricks.medicorner.data.source.local.CategoriesDataModel;
import com.treebricks.medicorner.data.source.local.DealsDataModel;
import com.treebricks.medicorner.data.source.local.HeaderAdsModel;
import com.treebricks.medicorner.data.source.local.ProductDataModel;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mainView;
    private HeaderAdsModel headerAdsModel;
    private CategoriesDataModel categoriesDataModel;
    private DealsDataModel dealsDataModel;
    private ProductDataModel productDataModel;

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        this.mainView.setPresenter(this);


        this.headerAdsModel = new HeaderAdsModel();
        this.categoriesDataModel = new CategoriesDataModel();
        this.dealsDataModel = new DealsDataModel();
        this.productDataModel = new ProductDataModel();
    }

    private void initRecyclerViews() {
        mainView.populateHeadersAdsRecyclerView(headerAdsModel.getHeaderAds());
        mainView.populateCategoriesRecyclerView(categoriesDataModel.getCategories());
        mainView.populateAfterCategoryAdsRecyclerView(headerAdsModel.getHeaderAds());
        mainView.populateDealsRecyclerView(dealsDataModel.getDeals());
        mainView.populateHotSellerRecyclerView(productDataModel.getProducts());
    }

    public void onItemClicked(Ads ads) {
        if (mainView != null) {
            Log.d("HeaderAdsClick", "Header Ads Clicked " + String.valueOf(ads.getImageUrl()));
        }
    }

    public void onItemClicked(Category category) {
        if (mainView != null) {
            Log.d("CategoryClick", "Category Clicked " + String.valueOf(category.getName()));
        }
    }

    public void onItemClicked(Deal deal) {
        if (mainView != null) {
            Log.d("CategoryClick", "Deal Clicked " + String.valueOf(deal.getName()));
        }
    }

    public void onItemClicked(Product product) {
        if (mainView != null) {
            Log.d("ProductClick", "Product Clicked " + String.valueOf(product.getName()));
        }
    }

    public void onDestroy() {
        mainView = null;
    }

    public void onMoreCategoryClick() {
        mainView.onMoreCategoryClicked();
    }

    public void onMoreDealClicked() {
        mainView.onMoreDealClicked();
    }

    @Override
    public void start() {
        initRecyclerViews();
    }
}
