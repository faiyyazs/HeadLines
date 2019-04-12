package com.headlines.data.repo.protocols;

import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.data.repo.IBaseLocalProtocol;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface INewsFeedLocalRepo extends IBaseLocalProtocol<FeedsEntity> {


    LiveData<List<FeedsEntityWithMedia>> getAllWithMedia();
}
