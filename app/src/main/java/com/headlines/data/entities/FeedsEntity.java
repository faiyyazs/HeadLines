package com.headlines.data.entities;

import com.headlines.data.Tables;
import com.headlines.data.converters.DateConverter;
import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.utility.LoggerUtil;

import java.text.ParseException;
import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Tables.NEWS)
public class FeedsEntity {

    @PrimaryKey(autoGenerate = false)
    private long id;
    private String title = "";

    protected String brief = "";
    private Date published = new Date();
    private String source = "";
    private Date lastUpdated = new Date();
    private String section = "";
    private String byline = "";
    private String url = "";


    public FeedsEntity (){
    }


    @Ignore
    public FeedsEntity (FeedsResponseEntity entity) throws ParseException {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.brief = entity.getDescription();
        try {
            this.published = DateConverter.dateStringToDate(entity.getPublishedDateString(),false);
        } catch (ParseException e) {
            LoggerUtil.printError(FeedsEntity.class,e.getMessage());
            throw e;
        }
        this.source = entity.getSource();
        try {
            this.lastUpdated = DateConverter.dateStringToDate(entity.getUpdatedString(),true);
        } catch (ParseException e) {
            LoggerUtil.printError(FeedsEntity.class,e.getMessage());
            throw e;
        }
        this.section = entity.getSection();
        this.byline = entity.getByline();
        this.url = entity.getUrl();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date publishedDate) {
        this.published = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date updated) {
        this.lastUpdated = updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
