package com.headlines.data.repo.impl;

import com.headlines.data.dao.impl.NewsDao;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.data.repo.protocols.INewsFeedLocalRepo;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NewsFeedLocalRepoImpl implements INewsFeedLocalRepo {

    private NewsDao newsDao;

    public NewsFeedLocalRepoImpl(NewsDao dao){
        newsDao = dao;
    }

    @Override
    public LiveData<List<FeedsEntity>> getAll() {
        return newsDao.getAllNews();
    }

    @Override
    public Long insert(FeedsEntity entity) {
        return newsDao.insert(entity);
    }

    @Override
    public List<Long> insert(List<FeedsEntity> entities) {
        return newsDao.insert(entities);
    }

    @Override
    public LiveData<List<FeedsEntityWithMedia>> getAllWithMedia() {
        return newsDao.getAllNewswithMedia();
    }
}
