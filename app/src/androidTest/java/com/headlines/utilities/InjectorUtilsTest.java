package com.headlines.utilities;


import android.content.Context;

import com.headlines.data.ApplicationDatabase;
import com.headlines.utility.InjectorUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class InjectorUtilsTest {


    private ApplicationDatabase applicationDatabase;


    @Before
    public void init(){
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        applicationDatabase = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase.class).build();
    }

    @Test
    public void testFeedsRepository(){
        assertNotNull(InjectorUtils.provideFeedsRepository(applicationDatabase));
    }


    @Test
    public void testLocalFeedsRepository(){
        assertNotNull(InjectorUtils.provideINewsFeedLocalRepo(applicationDatabase));
    }


    @Test
    public void testIMediaLocalRepo(){
        assertNotNull(InjectorUtils.provideIMediaLocalRepo(applicationDatabase));
    }



    @Test
    public void testFeedsMapper(){
        assertNotNull(InjectorUtils.provideFeedsMapper());
    }






}
