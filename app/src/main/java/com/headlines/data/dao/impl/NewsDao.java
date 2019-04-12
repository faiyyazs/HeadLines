package com.headlines.data.dao.impl;

import com.headlines.data.dao.BaseDao;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.entities.FeedsEntityWithMedia;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface NewsDao extends BaseDao<FeedsEntity> {

    @Query("Select * from news")
    public LiveData<List<FeedsEntity>> getAllNews();

    @Transaction
    @Query("Select * from news order by lastUpdated DESC")
    public LiveData<List<FeedsEntityWithMedia>> getAllNewswithMedia();

}
