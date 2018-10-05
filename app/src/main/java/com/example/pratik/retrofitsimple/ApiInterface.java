package com.example.pratik.retrofitsimple;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("trekking")
    Call<List<PlaceList>> getPlaceLists();


}

