package com.example.newz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopHeadLine {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private List<Article> articleList;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
