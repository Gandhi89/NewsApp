package com.example.android.newsapp.Adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.ApiResponseInJava.Article;
import com.example.android.newsapp.R;
import com.squareup.picasso.Picasso;

public class ArticleAdapter extends PagedListAdapter<Article, ArticleAdapter.ViewHolder> {

    private static DiffUtil.ItemCallback<Article> DIFF_CALL = new DiffUtil.ItemCallback<Article>() {
        @Override
        public boolean areItemsTheSame(Article oldItem, Article newItem) {
            return oldItem.getTitle() == newItem.getTitle();
        }

        @Override
        public boolean areContentsTheSame(Article oldItem, Article newItem) {
            return oldItem.equals(newItem);
        }
    };
    Context context;

    public ArticleAdapter(Context context) {
        super(DIFF_CALL);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView article_title;
        ImageView news_image;

        public ViewHolder(View itemView) {
            super(itemView);
            article_title = itemView.findViewById(R.id.article_title);
            news_image = itemView.findViewById(R.id.news_image);
        }

        public void bind(int position) {

            Article article = getItem(position);
            if (article != null) {
                article_title.setText(article.title);
                Picasso.get().load(article.urlToImage).into(news_image);
            }

        }
    }
}
