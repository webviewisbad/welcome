package com.koexample.one.welcome;

public class DateUtil {
    /**
     * 获取当前系统时间
     * @return
     */
    public long getDate() {
        return System.currentTimeMillis();
    }

    /**
     *获取不同时间点的时间差
     * @param oldtime
     * @param newtime
     * @return
     */
    public int getDiff(long oldtime, long newtime) {
        if (newtime > oldtime && oldtime > 0) {
            long diff = newtime - oldtime;
            return (int) (diff / (1000 * 24 * 60 * 60));
        } else {
            return -1;
        }
    }
}
