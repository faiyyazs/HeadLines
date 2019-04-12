package com.headlines.remote.services;


import com.headlines.remote.response.news.MostPopularNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsServices {


    @GET("mostpopular/v2/emailed/1.json?api-key="+BaseService.KEY)
    Call<MostPopularNewsResponse> getNewsArticles();

}
