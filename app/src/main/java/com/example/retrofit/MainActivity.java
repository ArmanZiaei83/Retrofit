package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    JsonPlaceHolderApi jsonPlaceHolderApi;
    public TextView textViewResult;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_result_view);

          final Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl("https://jsonplaceholder.typicode.com/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
          jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
          getPosts();
//          getComments();
      }
      public void getComments(){

          Call<List<Comments>> call = jsonPlaceHolderApi.getComments(3);
          call.enqueue(new Callback<List<Comments>>() {
              @Override
              public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                  if(!response.isSuccessful()){
                      textViewResult.setText(response.code());
                      return;
                  }

                  List<Comments> comments = response.body();

                  for(Comments comments1 : comments){
                      String con = "" ;
                      con += "postId :" + comments1.getPostId() + "\n";
                      con += "id :" + comments1.getId() + "\n";
                      con += "name :" + comments1.getName() + "\n";
                      con += "email :" + comments1.getEmail() + "\n";
                      con += "Body :" + comments1.getBody() + "\n\n";

                      textViewResult.append(con);
                  }
              }

              @Override
              public void onFailure(Call<List<Comments>> call, Throwable t) {
                    textViewResult.setText("Problem : " + t.getMessage());
              }
          });
      }

      public void getPosts(){

          Call<List<Post>> call = jsonPlaceHolderApi.getPosts(5);
          call.enqueue(new Callback<List<Post>>() {
              @Override
              public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                  if (!response.isSuccessful()){
                      textViewResult.setText("Code : " + response.code());
                      return;
                  }

                  List<Post> posts = response.body();

                  for (Post post : posts){
                      String con = "" ;
                      con += "ID : " + post.getId() + "\n" ;
                      con += "UserId : " + post.getUserId() + "\n";
                      con += "Title : " + post.getTitle() + "\n";
                      con += "Body : " + post.getText() + "\n\n";

                      textViewResult.append(con);
                  }
              }

              @Override
              public void onFailure(Call<List<Post>> call, Throwable t) {
                  textViewResult.setText(t.getMessage());
              }
          });
      }
}