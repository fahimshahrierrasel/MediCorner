package com.treebricks.medicorner.datamodels;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDataModel {
    List<Product> products;

    public ProductDataModel() {
        this.products = new ArrayList<>();

        populateData();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void populateData() {
        for (int i = 1; i < 8; i++) {
            Product product = new Product();
            product.setName("Product Name " + String.valueOf(i));
            product.setImage(R.mipmap.ic_launcher);
            product.setCurrentPrice(String.valueOf(123.33) + " BDT");
            product.setPreviousPrice(String.valueOf(119.27) + " BDT");

            products.add(product);
        }
    }
}
