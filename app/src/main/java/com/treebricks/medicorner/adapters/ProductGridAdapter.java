package com.treebricks.medicorner.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.model.Product;

import java.util.List;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductGridViewHolder>{
    private List<Product> products;
    private Listener listener;

    public interface Listener {
        void onItemClicked(Product product);
    }

    public ProductGridAdapter(List<Product> products, Listener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductGridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_grid, viewGroup, false);

        return new ProductGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductGridViewHolder holder, int i) {
        Product product = products.get(i);
        holder.bind(product, listener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductGridViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView prevPrice;
        TextView curPrice;

        ProductGridViewHolder(View itemView) {
            super(itemView);
            this.productImage = itemView.findViewById(R.id.iv_product_image);
            this.productName = itemView.findViewById(R.id.tv_product_name);
            this.prevPrice = itemView.findViewById(R.id.tv_prev_price);
            this.curPrice = itemView.findViewById(R.id.tv_curr_price);
        }

        public void bind(final Product item, final Listener listener) {

            productImage.setImageResource(item.getImage());
            productName.setText(item.getName());
            prevPrice.setText(item.getPreviousPrice());
            curPrice.setText(item.getCurrentPrice());

            itemView.setOnClickListener(view -> listener.onItemClicked(item));
        }
    }
}
