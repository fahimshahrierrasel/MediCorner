package com.treebricks.medicorner.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.treebricks.medicorner.R;
import com.treebricks.medicorner.data.model.Ads;

import java.util.List;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder>{
    private List<Ads> headerAds;
    private Listener listener;

    public interface Listener {
        void onItemClicked(Ads ads);
    }

    public AdsAdapter(List<Ads> headerAds, Listener listener) {
        this.headerAds = headerAds;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_ads_card, viewGroup, false);

        return new AdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int i) {
        Ads ads = headerAds.get(i);
        holder.bind(ads, listener);
    }

    @Override
    public int getItemCount() {
        return headerAds.size();
    }

    static class AdsViewHolder extends RecyclerView.ViewHolder {
        ImageView adsImage;

        AdsViewHolder(View itemView) {
            super(itemView);
            this.adsImage = itemView.findViewById(R.id.iv_ads_image);
        }

        public void bind(final Ads item, final Listener listener) {
            adsImage.setBackgroundColor(
                    itemView.getContext()
                            .getResources()
                            .getColor(item.getImageUrl()));

            itemView.setOnClickListener(view -> listener.onItemClicked(item));
        }
    }
}

