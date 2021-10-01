package com.example.loginregisterwithphp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> getRegisterResponse(
            @Field("username") String userName,
            @Field("email") String email,
            @Field("password") String password


    );
}
