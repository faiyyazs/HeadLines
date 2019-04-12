package com.headlines.repository;

import android.content.Context;

import com.headlines.data.ApplicationDatabase;
import com.headlines.utilities.LiveDataTestUtil;
import com.headlines.utility.InjectorUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertNotNull;

public class NewsFeedRepositoryTest {

    private NewsFeedsRepository repository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();



    @Before
    public void initialize(){
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        repository = InjectorUtils.provideFeedsRepository(Room.inMemoryDatabaseBuilder(context, ApplicationDatabase.class).build());
    }


    @Test
    public void testRepository(){
        try {
            assertNotNull(LiveDataTestUtil.getValue(repository.loadMostPopularFeeds()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
