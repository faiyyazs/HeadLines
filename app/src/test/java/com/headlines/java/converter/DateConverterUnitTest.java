package com.headlines.java.converter;


import com.headlines.data.converters.DateConverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class DateConverterUnitTest {

    // 2019-04-2014 02:46:11 ==> 1554326171000L


    @Test
    public void ifDateValiddate() throws ParseException {
        Date date = DateConverter.toDate(1554326171000L);
        assertEquals(1554326171000L,date.getTime());
        assertEquals("2019-04-04 02:46:11",DateConverter.formatDate(date,true));
     }


    @Test
    public void ifTimeisValiddate() throws ParseException {
        Date date = DateConverter.dateStringToDate("2019-04-04 02:46:11",true);
        assertEquals(1554326171000L,date.getTime());

    }


    @Test
    public void ifDateValiddateInvalid() {
        Date date = DateConverter.toDate(null);
        assertNull(date);

        Long time = DateConverter.toTime(null);
        assertNull(time);
    }


    @Test
    public void ifTimeisValiddateWithTime() throws ParseException {
        Date date = DateConverter.dateStringToDate("2019-04-04 02:46:11",true);
        assertEquals(1554326171000L,date.getTime());

    }
}
