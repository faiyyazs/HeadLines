package com.headlines.data.entities;

import com.headlines.data.Tables;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

// ForeignKey(entity = CityEntity::class,parentColumns = ["id"],childColumns = ["cityId"]),
@Entity(tableName = Tables.MEDIA,foreignKeys = {
        @ForeignKey(entity = FeedsEntity.class,parentColumns = "id",childColumns = "fid",
        onDelete = CASCADE,
        onUpdate = CASCADE)
})
public class MediaEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private long fid;
    private String url = "";
    private int height = 0;
    private int width = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
