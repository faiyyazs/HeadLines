package com.headlines.data.dao.impl;

import com.headlines.data.dao.BaseDao;
import com.headlines.data.entities.MediaEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface MediaDao extends BaseDao<MediaEntity> {

    @Query("Select * from media")
    public LiveData<List<MediaEntity>> getAllMedia();

}
