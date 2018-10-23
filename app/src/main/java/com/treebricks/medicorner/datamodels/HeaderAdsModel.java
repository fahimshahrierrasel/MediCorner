package com.treebricks.medicorner.datamodels;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.model.Ads;

import java.util.ArrayList;
import java.util.List;

public class HeaderAdsModel {
    private List<Ads> headerAds;

    public HeaderAdsModel() {
        headerAds = new ArrayList<>();
        populateAds();
    }

    public List<Ads> getHeaderAds() {
        return headerAds;
    }

    private void populateAds() {
        headerAds.add(new Ads(R.color.colorAccent));
        headerAds.add(new Ads(R.color.colorPrimary));
        headerAds.add(new Ads(R.color.colorPrimaryDark));
        headerAds.add(new Ads(R.color.colorAccent));
        headerAds.add(new Ads(R.color.colorPrimary));
        headerAds.add(new Ads(R.color.colorPrimaryDark));
    }
}
