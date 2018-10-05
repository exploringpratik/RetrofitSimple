package com.example.pratik.retrofitsimple;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context mcontext = HomeActivity.this;
    private RecyclerView recyclerView;
    PlaceList placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //For No tittle
//      requestWindowFeature(Window.FEATURE_NO_TITLE);
//             getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

//       setToolbar();
        initViews();


    }

    private void initViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.smoothScrollToPosition(0);

        loadJSONUsiingRetrofit();
    }

    private void loadJSONUsiingRetrofit() {

        try {
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<PlaceList>> call = apiInterface.getPlaceLists();
            call.enqueue(new Callback<List<PlaceList>>() {
                @Override
                public void onResponse(Call<List<PlaceList>> call, Response<List<PlaceList>> response) {
                    generateData(response.body());

                }

                @Override
                public void onFailure(Call<List<PlaceList>> call, Throwable t) {
                    // JsonReader.setLenient(true);
                    Log.d("Error", t.getMessage());
                    Toast.makeText(HomeActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    private void generateData(List<PlaceList> placeLists) {
        recyclerView.setAdapter(new CategoryAdapter(placeLists, getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
    }

}

