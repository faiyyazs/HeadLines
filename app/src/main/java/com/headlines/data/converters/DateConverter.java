package com.headlines.data.converters;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.room.Ignore;
import androidx.room.TypeConverter;


public class DateConverter {



    private DateConverter(){}


    @TypeConverter
    public static Date toDate(Long timestamp){
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }



    @TypeConverter
    public static Long toTime(Date date){
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }



    @Ignore
    private static DateFormat getDateInstance(boolean time) {
        if(time){
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }else{
          return  new SimpleDateFormat("yyyy-MM-dd");
        }
    }



    @Ignore
    public static Date dateStringToDate(String dateString,boolean time) throws ParseException {
        DateFormat formatter =   getDateInstance(time);
        Date date =   formatter.parse(dateString);
        if (date == null) {
            return null;
        } else {
            return date;
        }
    }

    @Ignore
    public static String formatTime(String dateString,boolean time) throws ParseException {
            return getDateInstance(time).format(dateStringToDate(dateString,time));
    }

    @Ignore
    public static String formatDate(Date date,boolean time) {
        return getDateInstance(time).format(date);
    }


}
