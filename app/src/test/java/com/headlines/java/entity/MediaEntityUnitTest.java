package com.headlines.java.entity;


import com.headlines.data.entities.MediaEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MediaEntityUnitTest {

    @Test
    public void testId(){
        MediaEntity entity = new MediaEntity();
        entity.setId(1);
        assertEquals(1,entity.getId());

    }


    @Test
    public void testFid(){
        MediaEntity entity = new MediaEntity();
        entity.setFid(1);
        assertEquals(1,entity.getFid());

    }

    @Test
    public void testUrl(){
        MediaEntity entity = new MediaEntity();
        entity.setUrl("URL");
        assertEquals("URL",entity.getUrl());
    }


    @Test
    public void testheight(){
        MediaEntity entity = new MediaEntity();
        entity.setHeight(10);
        assertEquals(10,entity.getHeight());
    }


    @Test
    public void testWidth(){
        MediaEntity entity = new MediaEntity();
        entity.setWidth(10);
        assertEquals(10,entity.getWidth());
    }
}
