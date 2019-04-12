package com.headlines.data;

import android.content.Context;

import com.headlines.data.dao.impl.NewsDao;
import com.headlines.data.entities.FeedsEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static com.headlines.utilities.LiveDataTestUtil.getValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class FeedsDaoInstrumentationTest {

    private ApplicationDatabase applicationDatabase;
    private NewsDao newsDao;
    private int numberOfRecords = 3;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initialize(){
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        applicationDatabase = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase.class).build();
        newsDao = applicationDatabase.getNewsDao();
        for (int i = 0; i < numberOfRecords; i++) {
            FeedsEntity feedsEntity = new FeedsEntity();
            feedsEntity.setId(i);
            feedsEntity.setTitle("My news Title "+i);
            feedsEntity.setBrief("News Brief" + i);
            feedsEntity.setUrl("http://google.co.in/");
            feedsEntity.setByline("By Author "+i);
            feedsEntity.setSource( "Source");
            feedsEntity.setPublished(new Date());
            newsDao.insert(feedsEntity);
        }
    }


    @After
    public void end(){
        applicationDatabase.close();
    }

    @Test
    public void testGetNewsFeedsList(){
        try {
            List<FeedsEntity> value = getValue(newsDao.getAllNews());
            assertThat(value.size(),equalTo(numberOfRecords));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}
