package com.headlines.data.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(T entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(List<T> entities);

    @Delete
    void delete(T entity);

}