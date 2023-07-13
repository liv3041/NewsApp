package com.example.newz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String API_KEY = "d7aaf822f62c492b974dd21e3465369e";

    private RecyclerView rvNews;
    private ProgressBar progressBar;
    private List<Article> articleList;
    private NewsAdapter newsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getNews();

    }

    private void setRecyclerView() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
//        newsAdapter = new NewsAdapter(this,articleList);
        rvNews.setAdapter(newsAdapter);


    }

    private void getNews() {

        WebService webService = WebServiceClient.getClient().create(WebService.class);
        Call<TopHeadLine> call = webService.getTopHeadlines("in", API_KEY);
        call.enqueue(new Callback<TopHeadLine>() {
            @Override
            public void onResponse(Call<TopHeadLine> call, Response<TopHeadLine> response) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG,"onResponse: " + response.code());
                assert response.body() != null : "Response Body Empty";
                articleList = response.body().getArticleList();
                newsAdapter = new NewsAdapter(MainActivity.this,articleList);
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<TopHeadLine> call, Throwable t) {
                  progressBar.setVisibility(View.GONE);
                  Log.d(TAG,"onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void init(){
        articleList = new ArrayList<>();
        rvNews = findViewById(R.id.rv_movies);
        progressBar = findViewById(R.id.progress_bar);

    }

}