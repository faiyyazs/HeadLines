package com.headlines.data;

import android.content.Context;

import com.headlines.data.converters.DateConverter;
import com.headlines.data.dao.impl.MediaDao;
import com.headlines.data.dao.impl.NewsDao;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.entities.MediaEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@TypeConverters(DateConverter.class)
@Database(entities = { FeedsEntity.class, MediaEntity.class } , version = 1, exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {


    public abstract NewsDao getNewsDao();
    public abstract MediaDao getMediaDao();

    private static ApplicationDatabase instance = null;


    public static ApplicationDatabase getInstance(Context context){

            if(instance == null) {
                String databaseName = "NewsDb";
                instance = Room.databaseBuilder(context,
                        ApplicationDatabase.class,
                        databaseName).build();
            }

        return instance;
    }


}
