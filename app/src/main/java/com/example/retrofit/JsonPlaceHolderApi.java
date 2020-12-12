package com.example.retrofit;

import android.icu.text.MessagePattern;
import android.text.style.AlignmentSpan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    //We are Using https://jsonplaceholder.typicode.com/posts URL for Testing, so i used @GET ("posts") based on the URL.

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId")  int Id
    );

    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments ( @Path("id") int postId);

}
