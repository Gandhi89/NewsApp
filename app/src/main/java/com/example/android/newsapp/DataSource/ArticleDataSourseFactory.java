package com.example.android.newsapp.DataSource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.example.android.newsapp.ApiResponseInJava.Article;

public class ArticleDataSourseFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Article>> itemLiveDataSource = new MutableLiveData<>();

    @Override
    public DataSource create() {

        ArticleDataSource articleDataSource = new ArticleDataSource();
        itemLiveDataSource.postValue(articleDataSource);
        return articleDataSource;

    }

    public MutableLiveData<PageKeyedDataSource<Integer, Article>> getArticleMutableLiveData() {
        return itemLiveDataSource;
    }
}
