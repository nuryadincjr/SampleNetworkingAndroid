package com.nuryadincjr.samplenetworkingandroid.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.samplenetworkingandroid.databinding.ItemPokemonBinding;
import com.nuryadincjr.samplenetworkingandroid.model.ResultsItem;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<ResultsItem> data;
    private Context context;

    public PokemonAdapter(List<ResultsItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        ResultsItem item = data.get(position);
        holder.setDataToView(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
