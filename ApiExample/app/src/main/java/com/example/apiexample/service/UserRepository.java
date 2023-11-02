package com.example.apiexample.service;

import com.example.apiexample.model.UserList;

import retrofit2.Call;

public class UserRepository {
    private RandomUser randomUserService;

    public UserRepository(RandomUser userService) {
        this.randomUserService = userService;
    }

    public Call<UserList> getListOfUsers(int numUsers, String nationality) {
        return randomUserService.getUsers(numUsers, nationality);
    }
}
