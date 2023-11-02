package com.example.apiexample.service;

import com.example.apiexample.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUser {
    // For documentation see
    // https://randomuser.me/documentation

    @GET("api/?noinfo")
    Call<UserList> getUsers(@Query("results") Integer numUsers,
                            @Query("nat") String nat);
}