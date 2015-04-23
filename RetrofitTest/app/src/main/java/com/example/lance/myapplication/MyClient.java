package com.example.lance.myapplication;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lance on 15-4-13.
 */
public class MyClient {
    private static final String MY_API_URI = "http://10.0.2.2";
    static class User{
        int id;
        String name;
        @Override
        public String toString() {
            return "id:" + id + " , name:" + name;
        }
    }
    interface GetUsers{
        @GET("/hello.php")
        void getUsers(Callback<List<User>> callback);
    }
    public static void getUsers(Callback<List<User>> callback){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(MY_API_URI).build();
        GetUsers getUsers = restAdapter.create(GetUsers.class);
        getUsers.getUsers(callback);
    }
}
