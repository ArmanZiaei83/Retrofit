package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    //We are Using https://jsonplaceholder.typicode.com/posts URL for Testing, so i used @GET ("posts") based on the URL.

    @GET("post")
    Call<List> getPosts() ;
 }
