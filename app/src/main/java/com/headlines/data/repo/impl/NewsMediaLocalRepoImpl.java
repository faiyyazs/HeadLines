package com.headlines.data.repo.impl;

import com.headlines.data.dao.impl.MediaDao;
import com.headlines.data.entities.MediaEntity;
import com.headlines.data.repo.protocols.IMediaLocalRepo;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NewsMediaLocalRepoImpl implements IMediaLocalRepo {

    private MediaDao mediaDao;

    public NewsMediaLocalRepoImpl(MediaDao dao){
        mediaDao = dao;
    }

    @Override
    public LiveData<List<MediaEntity>> getAll() {
        return mediaDao.getAllMedia();
    }

    @Override
    public Long insert(MediaEntity entity) {
        return mediaDao.insert(entity);
    }

    @Override
    public List<Long> insert(List<MediaEntity> entities) {
        return mediaDao.insert(entities);
    }
}
