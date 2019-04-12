package com.headlines.utility;

import com.headlines.data.ApplicationDatabase;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.repo.impl.NewsFeedLocalRepoImpl;
import com.headlines.data.repo.impl.NewsMediaLocalRepoImpl;
import com.headlines.data.repo.protocols.IMediaLocalRepo;
import com.headlines.data.repo.protocols.INewsFeedLocalRepo;
import com.headlines.mappers.FeedsMapper;
import com.headlines.mappers.IEntityMapper;
import com.headlines.remote.request.news.INewsRequest;
import com.headlines.remote.request.news.NewsRequestImpl;
import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.remote.services.NewsServices;
import com.headlines.repository.NewsFeedsRepository;

public class InjectorUtils {


    private InjectorUtils(){
        throw new IllegalStateException("Utility class");
    }


    public static NewsFeedsRepository provideFeedsRepository(ApplicationDatabase database){
        return new NewsFeedsRepository(provideINewsFeedLocalRepo(database),
                provideIMediaLocalRepo(database),
                provideNewsRequest(),
                provideFeedsMapper());
    }

    public static INewsFeedLocalRepo provideINewsFeedLocalRepo(ApplicationDatabase database){
        return new NewsFeedLocalRepoImpl(database.getNewsDao());
    }


    public static IMediaLocalRepo provideIMediaLocalRepo(ApplicationDatabase database){
        return new NewsMediaLocalRepoImpl(database.getMediaDao());
    }


    public static INewsRequest<FeedsEntity> provideNewsRequest(){
        return new NewsRequestImpl(NewsServices.class);
    }

    public static IEntityMapper<FeedsEntity, FeedsResponseEntity> provideFeedsMapper(){
        return new FeedsMapper();
    }



}
