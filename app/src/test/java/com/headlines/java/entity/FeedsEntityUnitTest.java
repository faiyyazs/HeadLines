package com.headlines.java.entity;


import com.headlines.data.converters.DateConverter;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.mappers.FeedsMapper;
import com.headlines.remote.response.entity.FeedsResponseEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FeedsEntityUnitTest {



    @Test
    public void testId(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setId(100L);
        assertEquals(100L,feedsEntity.getId());
    }



    @Test
    public void testTitle(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setTitle("Title");
        assertEquals("Title",feedsEntity.getTitle());
    }


    @Test
    public void testBrief(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setBrief("Brief");
        assertEquals("Brief",feedsEntity.getBrief());
    }


    @Test
    public void testPublishedDate(){
        FeedsEntity feedsEntity = new FeedsEntity();
        Date date = DateConverter.toDate(1554326171000L);
        feedsEntity.setPublished(date);

        assertEquals(1554326171000L,feedsEntity.getPublished().getTime());
    }


    @Test
    public void testSource(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setSource("Source");
        assertEquals("Source",feedsEntity.getSource());
    }


    @Test
    public void testByline(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setByline("byLine");
        assertEquals("byLine",feedsEntity.getByline());
    }

    @Test
    public void testSection(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setSection("Section");
        assertEquals("Section",feedsEntity.getSection());
    }

    @Test
    public void testUrl(){
        FeedsEntity feedsEntity = new FeedsEntity();
        feedsEntity.setUrl("URL");
        assertEquals("URL",feedsEntity.getUrl());
    }


    @Test
    public void testUpdatedDate(){
        FeedsEntity feedsEntity = new FeedsEntity();
        Date date = DateConverter.toDate(1554326171000L);
        feedsEntity.setLastUpdated(date);
        assertEquals(1554326171000L,feedsEntity.getLastUpdated().getTime());
    }



    @Test
    public void testInitializer(){

        try {
            FeedsMapper feedsMapper  = new FeedsMapper();
            FeedsResponseEntity entity = new FeedsResponseEntity();
            FeedsEntity feedsEntity = feedsMapper.convertDSEntityToData(entity);
            assertEquals(0L,feedsEntity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConversion(){

        try {
            FeedsResponseEntity entity = new FeedsResponseEntity();
            entity.setPublishedDate("2019-04-04 02:46:11");
            entity.setUpdated("2019-04-04 02:46:11");
            FeedsEntity feedsEntity = new FeedsEntity(entity);
            assertEquals(0L,feedsEntity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
