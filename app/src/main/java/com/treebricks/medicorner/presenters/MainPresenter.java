package com.treebricks.medicorner.presenters;

import android.util.Log;

import com.treebricks.medicorner.datamodels.CategoriesDataModel;
import com.treebricks.medicorner.datamodels.DealsDataModel;
import com.treebricks.medicorner.datamodels.HeaderAdsModel;
import com.treebricks.medicorner.datamodels.ProductDataModel;
import com.treebricks.medicorner.model.Ads;
import com.treebricks.medicorner.model.Category;
import com.treebricks.medicorner.model.Deal;
import com.treebricks.medicorner.model.Product;
import com.treebricks.medicorner.views.MainView;

public class MainPresenter {
    private MainView mainView;
    private HeaderAdsModel headerAdsModel;
    private CategoriesDataModel categoriesDataModel;
    private DealsDataModel dealsDataModel;
    private ProductDataModel productDataModel;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        this.headerAdsModel = new HeaderAdsModel();
        this.categoriesDataModel = new CategoriesDataModel();
        this.dealsDataModel = new DealsDataModel();
        this.productDataModel = new ProductDataModel();
    }

    public void initPresenter() {
        mainView.populateHeadersAdsRecyclerView(headerAdsModel.getHeaderAds());
        mainView.populateCategoriesRecyclerView(categoriesDataModel.getCategories());
        mainView.populateAfterCategoryAdsRecyclerView(headerAdsModel.getHeaderAds());
        mainView.populateDealsRecyclerView(dealsDataModel.getDeals());
        mainView.populateHotSellerRecyclerView(productDataModel.getProducts());
    }

    public void onItemClicked(Ads ads) {
        if(mainView != null) {
            Log.d("HeaderAdsClick", "Header Ads Clicked " + String.valueOf(ads.getImageUrl()));
        }
    }

    public void onItemClicked(Category category) {
        if(mainView != null) {
            Log.d("CategoryClick", "Category Clicked " + String.valueOf(category.getName()));
        }
    }

    public void onItemClicked(Deal deal) {
        if(mainView != null) {
            Log.d("CategoryClick", "Deal Clicked " + String.valueOf(deal.getName()));
        }
    }

    public void onItemClicked(Product product) {
        if(mainView != null) {
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
}
