package com.treebricks.medicorner.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.data.model.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>{
    private List<Category> categories;
    private Listener listener;

    public interface Listener {
        void onItemClicked(Category category);
    }

    public CategoriesAdapter(List<Category> categories, Listener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int i) {
        Category category = categories.get(i);
        holder.bind(category, listener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryLogo;
        TextView categoryName;

        CategoryViewHolder(View itemView) {
            super(itemView);
            this.categoryLogo = itemView.findViewById(R.id.iv_category_image);
            this.categoryName = itemView.findViewById(R.id.tv_category_name);
        }

        public void bind(final Category item, final Listener listener) {

            categoryLogo.setImageResource(item.getLogo());
            categoryName.setText(item.getName());

            itemView.setOnClickListener(view -> listener.onItemClicked(item));
        }
    }
}
