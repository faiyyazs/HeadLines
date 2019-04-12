package com.headlines.remote.response.news;

import com.google.gson.annotations.SerializedName;
import com.headlines.remote.response.entity.FeedsResponseEntity;

import java.util.List;

public class MostPopularNewsResponse {

    @SerializedName("results")
    private List<FeedsResponseEntity> popularArticles;


    /**
     * This method return the list of article entities
     * @return List of entities
     */
    public List<FeedsResponseEntity> getPopularArticles() {
        return popularArticles;
    }

    /**
     * This method sets the article entities
     * @param popularArticles - articleslist
     */
    @SuppressWarnings("unused")
    public void setPopularArticles(List<FeedsResponseEntity> popularArticles) {
        this.popularArticles = popularArticles;
    }
}
