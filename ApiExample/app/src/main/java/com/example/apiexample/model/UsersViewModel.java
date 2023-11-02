package com.example.apiexample.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiexample.service.UserRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<User>> allUsers;

    public UsersViewModel() {
        super();
        allUsers = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void addAll(UserList list) {
        allUsers.getValue().addAll(list.getResults());
        allUsers.setValue(allUsers.getValue());
        Log.i("AJB", "Printing " + allUsers.getValue().size() + " Users");
        for (User user : allUsers.getValue()) {
            Log.i("AJB", user.toString());
        }
    }

    public void requestRandomUsers(UserRepository userRepository) {
        if (allUsers.getValue().size() == 0) {
            Call<UserList> userCall = userRepository.getListOfUsers(25, "gb");
            userCall.enqueue(new Callback<UserList>() {
                @Override
                public void onResponse(Call<UserList> call, Response<UserList> response) {
                    if (response.isSuccessful()) {
                        Log.i("AJB", response.body().toString());
                        addAll(response.body());
                    }
                }

                @Override
                public void onFailure(Call<UserList> call, Throwable t) {
                    // show error message to user
                    Log.i("AJB", "Error: " + t.toString());
                }
            });
        } else {
            Log.i("AJB", "Already got a list of users, not getting any more");
        }
    }
}