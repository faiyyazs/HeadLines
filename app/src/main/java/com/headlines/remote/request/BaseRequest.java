package com.headlines.remote.request;

import com.headlines.remote.services.BaseService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRequest<T> {

    private String baseUrl;
    private Class<T> clazz;

    private BaseRequest(Class<T> clazz,
                        String baseUrl){
        this.baseUrl = baseUrl;
        this.clazz =  clazz;
    }

    public BaseRequest(Class<T> clazz){
       this(clazz,BaseService.BASE_URL);
    }


    protected T makeRequest() {
        return makeRetrofitService(baseUrl).create(this.clazz);
    }

    private Retrofit makeRetrofitService(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(makeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient makeOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(makeLoggingInterceptor())
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .build();
    }

    private HttpLoggingInterceptor makeLoggingInterceptor()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }


}
