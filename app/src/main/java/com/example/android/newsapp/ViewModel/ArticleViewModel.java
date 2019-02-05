package com.example.android.newsapp.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.example.android.newsapp.ApiResponseInJava.Article;
import com.example.android.newsapp.DataSource.ArticleDataSourseFactory;

public class ArticleViewModel extends ViewModel {

    public LiveData<PagedList<Article>> liveDataSource;
    private LiveData<PageKeyedDataSource<Integer, Article>> articlePagedList;

    public ArticleViewModel() {
        ArticleDataSourseFactory articleDataSourseFactory = new ArticleDataSourseFactory();
        articlePagedList = articleDataSourseFactory.getArticleMutableLiveData();

        PagedList.Config config = new PagedList.Config.Builder().setEnablePlaceholders(false)
                .setPageSize(50)
                .build();

        liveDataSource = (new LivePagedListBuilder(articleDataSourseFactory, config)).build();
    }
}
