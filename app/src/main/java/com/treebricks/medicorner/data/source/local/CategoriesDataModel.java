package com.treebricks.medicorner.data.source.local;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.data.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesDataModel {
    private List<Category> categories;

    public CategoriesDataModel() {
        categories = new ArrayList<>();
        populateCategories();
    }

    public List<Category> getCategories() {
        return categories;
    }

    private void populateCategories() {
        categories.add(new Category(R.mipmap.ic_launcher_round, "Prescription"));
        categories.add(new Category(R.mipmap.ic_launcher, "Ayush"));
        categories.add(new Category(R.mipmap.ic_launcher_round, "Fitness"));
        categories.add(new Category(R.mipmap.ic_launcher, "Baby Care"));
        categories.add(new Category(R.mipmap.ic_launcher_round, "Cosmetics"));
        categories.add(new Category(R.mipmap.ic_launcher, "Toiletries"));
    }
}
