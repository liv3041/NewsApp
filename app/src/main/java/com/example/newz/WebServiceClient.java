package com.example.newz;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {
    //    setting up the API Client which will be used here to load the data from API
    static Retrofit getClient() {
        /* By using this WebServiceClient class and calling its getClient() method,
        you can obtain a configured Retrofit client that is ready to make network requests
        to the specified base URL with Gson as the JSON converter. **/
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}
