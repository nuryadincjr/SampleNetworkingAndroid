package com.nuryadincjr.samplenetworkingandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.nuryadincjr.samplenetworkingandroid.data.PokemonAdapter;
import com.nuryadincjr.samplenetworkingandroid.databinding.ActivityMainBinding;
import com.nuryadincjr.samplenetworkingandroid.model.BaseResponse;
import com.nuryadincjr.samplenetworkingandroid.model.ResultsItem;
import com.nuryadincjr.samplenetworkingandroid.network.ApiService;
import com.nuryadincjr.samplenetworkingandroid.network.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<ResultsItem> pokemonResult;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pokemonResult = new ArrayList<>();
        adapter = new PokemonAdapter(pokemonResult, this);
        binding.rvPokemon.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvPokemon.setAdapter(adapter);
        fetchPokemons();
    }

    private void fetchPokemons() {
        NetworkClient.getInstance().create(ApiService.class).getPokemon().enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if(response.code() == 200 && response.body() != null) {
                    List<ResultsItem> data = response.body().getResults();
                    pokemonResult.addAll(data);
                    adapter.notifyDataSetChanged();
                    Log.d("TES", String.valueOf(response.body().getResults().size()));

                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}