package com.headlines.java.entity;

import com.headlines.data.entities.MediaEntity;
import com.headlines.remote.response.news.MediaResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MediaResponseUnitTest {



    @Test
    public void testMedia(){
        List<MediaEntity> medias= new ArrayList<>();
        MediaResponse mediaResponse = new MediaResponse();
        mediaResponse.mediaEntities = medias;

        assertEquals(medias,mediaResponse.mediaEntities);
    }

}
