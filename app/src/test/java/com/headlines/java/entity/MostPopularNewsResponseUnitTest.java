package com.headlines.java.entity;


import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.remote.response.news.MostPopularNewsResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MostPopularNewsResponseUnitTest {



    @Test
    public void testResponse(){
        List<FeedsResponseEntity> list  = new ArrayList<>();
        MostPopularNewsResponse response = new MostPopularNewsResponse();
        response.setPopularArticles(list);
        assertEquals(list,response.getPopularArticles());

    }


}
