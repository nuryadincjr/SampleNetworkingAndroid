package com.nuryadincjr.samplenetworkingandroid.data;

import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.samplenetworkingandroid.databinding.ItemPokemonBinding;
import com.nuryadincjr.samplenetworkingandroid.model.ResultsItem;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    ItemPokemonBinding binding;

    public PokemonViewHolder(ItemPokemonBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataToView(ResultsItem item) {
        binding.tvPokemonName.setText(item.getName());
    }
}
