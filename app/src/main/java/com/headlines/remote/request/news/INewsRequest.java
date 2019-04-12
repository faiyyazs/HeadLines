package com.headlines.remote.request.news;

import com.headlines.remote.request.IBaseRequestProtocol;
import com.headlines.remote.response.news.MostPopularNewsResponse;

import retrofit2.Call;

public interface INewsRequest<T> extends IBaseRequestProtocol<T> {

    Call<MostPopularNewsResponse> fetchRemoteMostPopularNews();



}
