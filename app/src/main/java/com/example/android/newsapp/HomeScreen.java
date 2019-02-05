package com.example.android.newsapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.newsapp.Adapter.ArticleAdapter;
import com.example.android.newsapp.ApiResponseInJava.Article;
import com.example.android.newsapp.ViewModel.ArticleViewModel;

public class HomeScreen extends AppCompatActivity {

    public static final String API_KEY = "6f274090f44941f48161d85aed093033";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.homeScreen_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArticleViewModel articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

        final ArticleAdapter articleAdapter = new ArticleAdapter(this);

        articleViewModel.liveDataSource.observe(this, new Observer<PagedList<Article>>() {
            @Override
            public void onChanged(@Nullable PagedList<Article> articles) {
                articleAdapter.submitList(articles);
            }
        });

        recyclerView.setAdapter(articleAdapter);

        Toast.makeText(this, articleAdapter.getItemCount() + "", Toast.LENGTH_SHORT).show();
    }
}
