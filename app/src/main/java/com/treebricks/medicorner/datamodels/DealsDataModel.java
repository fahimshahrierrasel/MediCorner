package com.treebricks.medicorner.datamodels;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.model.Deal;

import java.util.ArrayList;
import java.util.List;

public class DealsDataModel {
    private List<Deal> deals;

    public DealsDataModel() {
        deals = new ArrayList<>();
        populateCategories();
    }

    public List<Deal> getDeals() {
        return deals;
    }

    private void populateCategories() {
        deals.add(new Deal(R.mipmap.ic_launcher_round, "Beximco Pharmacitacles", "UPTO 20%"));
        deals.add(new Deal(R.mipmap.ic_launcher_round, "Square Pharmacitacles", "UPTO 25%"));
        deals.add(new Deal(R.mipmap.ic_launcher_round, "Orion", "UPTO 23%"));
        deals.add(new Deal(R.mipmap.ic_launcher_round, "Acme", "UPTO 31%"));
        deals.add(new Deal(R.mipmap.ic_launcher_round, "ESKAYFE", "UPTO 5%"));
    }
}
