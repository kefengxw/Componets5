package com.componets5;

import android.provider.ContactsContract;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {

    private String mTime = "2017-10-15 16:00:02";
    private long timeStamp = 1508076002000L;
    //private Date mData;

    @Before
    public void setUp(){
        System.out.println("DateUtilTest Start testing");
        //mData = new Date();
        //mData.setTime(timeStamp);
    }

    @Test
    public void dateToStamp() {
        long timeStampTemp = 0;

        try {
            timeStampTemp = DateUtil.dateToStamp(mTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals(timeStamp, timeStampTemp);
    }

    @Test
    public void stampToDate() {

        String mTimeTemp;

        mTimeTemp = DateUtil.stampToDate(timeStamp);

        assertEquals(mTime, mTimeTemp);
    }

    @After
    public void tearDown(){
        System.out.println("DateUtilTest End testing");
    }
}