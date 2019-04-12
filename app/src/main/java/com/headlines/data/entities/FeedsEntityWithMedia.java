package com.headlines.data.entities;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;


public class FeedsEntityWithMedia  {

    @Embedded
    public FeedsEntity feedsEntity = new FeedsEntity();

    @Relation(parentColumn = "id",entityColumn = "fid" ,entity = MediaEntity.class)
    public List<MediaEntity> mediaEntity = new ArrayList();

}
