package com.headlines.utility;

public class Constants {


    private Constants(){
        throw new IllegalStateException("Utility class");
    }

    public static final String EXTRA_NEWSFEED_TITLE= "title";
    public static final String EXTRA_NEWSFEED_URL= "url";
    public static final String EXTRA_NEWSFEED_IMAGE_URL= "image_url";
    public static final String EXTRA_NEWSFEED_UPDATED_DATE= "updated";
}
