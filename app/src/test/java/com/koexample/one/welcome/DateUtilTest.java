package com.koexample.one.welcome;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class DateUtilTest {
    private DateUtil dateUtil;

    @Before
    public void setUp() throws Exception {
        dateUtil = new DateUtil();
    }

    @Test
    public void getDate() {
        long time = dateUtil.getDate();
        Calendar calendar = Calendar.getInstance();
        long time1 = calendar.getTimeInMillis();
        System.out.println(" " + time + " " + time1);
    }

    @Test
    public void getDiff() {
        Calendar calendar = Calendar.getInstance();
        long oldtime = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        long newtime = calendar.getTimeInMillis();
        System.out.println("Diff " + dateUtil.getDiff(oldtime, newtime));
        System.out.println("Diff " + dateUtil.getDiff(dateUtil.getDate(), newtime));
    }
}