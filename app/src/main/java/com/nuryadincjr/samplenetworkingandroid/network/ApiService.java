package com.nuryadincjr.samplenetworkingandroid.network;

import com.nuryadincjr.samplenetworkingandroid.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("pokemon")
    public Call<BaseResponse> getPokemon();
}
