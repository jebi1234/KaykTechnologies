package com.example.netcheckapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getdata.php")
    Call<List<DataModel>> getDataModels();

}
