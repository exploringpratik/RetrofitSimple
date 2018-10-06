package com.example.pratik.retrofitsimple;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("{api}/{trekking}")
    Call<List<PlaceList>> getPlaceLists(@Path("api") String api, @Path("trekking") String trekking);
}

