package com.headlines.remote.request.news;

import com.headlines.data.entities.FeedsEntity;
import com.headlines.remote.request.BaseRequest;
import com.headlines.remote.response.news.MostPopularNewsResponse;
import com.headlines.remote.services.NewsServices;

import retrofit2.Call;

public class NewsRequestImpl extends BaseRequest<NewsServices>
        implements INewsRequest<FeedsEntity> {


    public NewsRequestImpl(Class<NewsServices> clazz) {
        super(clazz);
    }

    @Override
    public Call<MostPopularNewsResponse> fetchRemoteMostPopularNews() {
        return makeRequest().getNewsArticles();

    }

}
