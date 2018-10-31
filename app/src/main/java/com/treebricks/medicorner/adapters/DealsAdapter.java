package com.treebricks.medicorner.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.data.model.Deal;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.DealViewHolder>{
    private List<Deal> deals;
    private Listener listener;

    public interface Listener {
        void onItemClicked(Deal deal);
    }

    public DealsAdapter(List<Deal> deals, Listener listener) {
        this.deals = deals;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.deals_view, viewGroup, false);

        return new DealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int i) {
        Deal deal = deals.get(i);
        holder.bind(deal, listener);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

    static class DealViewHolder extends RecyclerView.ViewHolder {
        ImageView dealImage;
        TextView dealName;
        TextView dealText;

        DealViewHolder(View itemView) {
            super(itemView);
            this.dealImage = itemView.findViewById(R.id.iv_deal_image);
            this.dealName = itemView.findViewById(R.id.tv_deal_name);
            this.dealText = itemView.findViewById(R.id.tv_deal_text);
        }

        public void bind(final Deal item, final Listener listener) {

            dealImage.setImageResource(item.getLogo());
            dealName.setText(item.getName());

            itemView.setOnClickListener(view -> listener.onItemClicked(item));
        }
    }
}
