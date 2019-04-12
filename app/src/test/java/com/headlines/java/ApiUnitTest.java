package com.headlines.java;

import com.headlines.remote.request.news.INewsRequest;
import com.headlines.remote.request.news.NewsRequestImpl;
import com.headlines.remote.services.NewsServices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ApiUnitTest {

    private INewsRequest request;

    @Before
    public void initialize(){
        request  = new NewsRequestImpl(NewsServices.class);
    }

    @Test
    public void requestNewsFeeds(){
        try {
            Response response = request.fetchRemoteMostPopularNews().execute();
            assertEquals(200,response.code());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
