package com.example.newz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface WebService {
    @GET("top-headlines")
    Call<TopHeadLine> getTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);
}
