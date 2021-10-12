package com.example.loggingapijava;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("authenticate/")
    Call<LoginResponse> userlogin(@Body LoginRequest loginRequest);

}
