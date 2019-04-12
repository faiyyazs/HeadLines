package com.headlines.remote.response.entity;

import com.google.gson.annotations.SerializedName;
import com.headlines.data.entities.FeedsEntity;
import com.headlines.remote.response.news.MediaResponse;

import java.util.ArrayList;
import java.util.List;

public class FeedsResponseEntity extends FeedsEntity {


    @SerializedName("abstract")
    private String brief = "";


    @SerializedName("published_date")
    private String publishedDate = "";
    private String updated = "";

    @SerializedName("media")
    private List<MediaResponse> mediaEntities;

    public FeedsResponseEntity() {
        mediaEntities = new ArrayList<>();
    }


    public String getDescription() {
        return brief;
    }

    public void setDescription(String description) {
        this.brief = description;
    }

    public String getPublishedDateString() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }


    public String getUpdatedString() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<MediaResponse> getMediaEntities() {
        return mediaEntities;
    }

    public void setMediaEntities(List<MediaResponse> mediaEntities) {
        this.mediaEntities = mediaEntities;
    }


}


