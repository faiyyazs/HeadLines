package com.headlines.repository;

import com.headlines.data.entities.FeedsEntity;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.data.entities.MediaEntity;
import com.headlines.data.repo.protocols.IMediaLocalRepo;
import com.headlines.data.repo.protocols.INewsFeedLocalRepo;
import com.headlines.mappers.IEntityMapper;
import com.headlines.remote.NetworkBoundResource;
import com.headlines.remote.Resource;
import com.headlines.remote.request.news.INewsRequest;
import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.remote.response.news.MediaResponse;
import com.headlines.remote.response.news.MostPopularNewsResponse;
import com.headlines.ui.callbacks.LoaderCallback;
import com.headlines.utility.LoggerUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

public class NewsFeedsRepository {


    private INewsFeedLocalRepo iNewsFeedLocalRepo;
    private IMediaLocalRepo iMediaLocalRepo;
    private INewsRequest<FeedsEntity> iNewsRequest;
    private IEntityMapper<FeedsEntity, FeedsResponseEntity> feedsMapper;

    public NewsFeedsRepository(INewsFeedLocalRepo iNewsFeedLocalRepo,
                               IMediaLocalRepo iMediaLocalRepo, INewsRequest<FeedsEntity> iNewsRequest,
                               IEntityMapper<FeedsEntity, FeedsResponseEntity> feedsMapper){
        this.iNewsFeedLocalRepo = iNewsFeedLocalRepo;
        this.iMediaLocalRepo =  iMediaLocalRepo;
        this.iNewsRequest = iNewsRequest;
        this.feedsMapper = feedsMapper;

    }

    public LiveData<Resource<List<FeedsEntityWithMedia>>> loadMostPopularFeeds(){

        return new NetworkBoundResource<List<FeedsEntityWithMedia>, MostPopularNewsResponse>() {

            @Override
            protected void saveCallResult(final MostPopularNewsResponse item) {
                    if(item != null) {
                                for (FeedsResponseEntity popularArticle : item.getPopularArticles()) {
                                    try {

                                        long feedsId = iNewsFeedLocalRepo.insert(feedsMapper.convertDSEntityToData(popularArticle));
                                        for (MediaResponse mediaEntity : popularArticle.getMediaEntities()) {
                                            for (MediaEntity entity : mediaEntity.mediaEntities) {
                                                entity.setFid(feedsId);
                                                iMediaLocalRepo.insert(entity);
                                            }
                                        }

                                    } catch (Exception e) {
                                        LoggerUtil.printError(NewsFeedsRepository.class, e.getMessage());
                                    }
                                }
                    }
            }


            @NonNull
            @Override
            protected LiveData<List<FeedsEntityWithMedia>> loadFromDb() {
                return iNewsFeedLocalRepo.getAllWithMedia();
            }

            @NonNull
            @Override
            protected Call<MostPopularNewsResponse> createCall() {
                return iNewsRequest.fetchRemoteMostPopularNews();
            }
        }.getAsLiveData();
    }



    public void loadNewsFeedFromUrl(final FeedsEntityWithMedia feedsEntityWithMedia, final String url, final LoaderCallback loaderCallback){
        Observable.fromCallable(() -> {
            Document document = Jsoup.connect(url).get();
            feedsEntityWithMedia.feedsEntity.setBrief(document.select("p").text());
            return feedsEntityWithMedia;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FeedsEntityWithMedia>() {
            @Override
            public void onSubscribe(Disposable d) {
               // Can be used for the means of cancelling (disposing) observer
            }

            @Override
            public void onNext(FeedsEntityWithMedia feedsEntityWithMedia) {
                loaderCallback.onSuccess(feedsEntityWithMedia);
            }

            @Override
            public void onError(Throwable e) {
                loaderCallback.onFailure(e.getMessage());
            }

            @Override
            public void onComplete() {
                // Can be used when all emissions are completed.
            }
        });




    }

}
