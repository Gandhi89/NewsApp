package com.example.android.newsapp.ApiResponseInJava;

import java.util.List;

public class News {

    public String status;
    public long totalResults;
    public List<Article> articles;

    public String getStatus() {
        return status;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
