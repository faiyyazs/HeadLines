package com.headlines.java.entity;

import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.remote.response.news.MediaResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FeedsResponseEntityUnitTest {



    @Test
    public void testId(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setId(100L);
        assertEquals(100L,feedsEntity.getId());
    }



    @Test
    public void testTitle(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setTitle("Title");
        assertEquals("Title",feedsEntity.getTitle());
    }


    @Test
    public void testBrief(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setDescription("Brief");
        assertEquals("Brief",feedsEntity.getDescription());
    }


    @Test
    public void testPublishedDate(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();

        feedsEntity.setPublishedDate("2019-04-04 02:46:11");

        assertEquals("2019-04-04 02:46:11",feedsEntity.getPublishedDateString());
    }


    @Test
    public void testSource(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setSource("Source");
        assertEquals("Source",feedsEntity.getSource());
    }


    @Test
    public void testByline(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setByline("byLine");
        assertEquals("byLine",feedsEntity.getByline());
    }

    @Test
    public void testSection(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setSection("Section");
        assertEquals("Section",feedsEntity.getSection());
    }

    @Test
    public void testUrl(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setUrl("URL");
        assertEquals("URL",feedsEntity.getUrl());
    }


    @Test
    public void testUpdatedDate(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        feedsEntity.setUpdated("2019-04-04 02:46:11");
        assertEquals("2019-04-04 02:46:11",feedsEntity.getUpdatedString());
    }


    @Test
    public void testMedia(){
        FeedsResponseEntity feedsEntity = new FeedsResponseEntity();
        List<MediaResponse> list = new ArrayList<>();
        feedsEntity.setMediaEntities(list);
        assertEquals(list,feedsEntity.getMediaEntities());
    }

}
