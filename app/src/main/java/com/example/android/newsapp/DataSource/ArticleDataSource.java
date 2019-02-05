package com.example.android.newsapp.DataSource;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.android.newsapp.ApiResponseInJava.Article;
import com.example.android.newsapp.ApiResponseInJava.News;
import com.example.android.newsapp.Client.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleDataSource extends PageKeyedDataSource<Integer, Article> {

    private static final int PAGE_SIZE = 50;
    private static final int TOTAL_PAGE = 6995;
    private static final int FIRST_PAGE = 1;
    private static final String API_KEY = "6f274090f44941f48161d85aed093033";


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Article> callback) {
        RetrofitClient.getInstance().getNewsAPI()
                .getNews("bitcoin", "2019-01-05", "publishedAt", API_KEY)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().articles, null, null);
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Article> callback) {
        RetrofitClient.getInstance().getNewsAPI()
                .getNews("bitcoin", "2019-01-03", "publishedAt", API_KEY)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (response.body() != null) {
//                            int totalCount = TOTAL_PAGE;
//                            int position = computeInitialLoadPosition(params, totalCount);
//                            int loadSize = computeInitialLoadSize(params, position, totalCount);
//                            callback.onResult(response.body().articles, position, loadSize);
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Article> callback) {

    }
}
