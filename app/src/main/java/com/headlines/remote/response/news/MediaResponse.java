package com.headlines.remote.response.news;

import com.google.gson.annotations.SerializedName;
import com.headlines.data.entities.MediaEntity;

import java.util.ArrayList;
import java.util.List;

public class MediaResponse {

    @SerializedName("media-metadata")
    public List<MediaEntity> mediaEntities = new ArrayList<>();

}
