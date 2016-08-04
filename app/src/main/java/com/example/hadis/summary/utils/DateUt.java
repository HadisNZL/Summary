package com.example.hadis.summary.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author hadis on 16.4.29.
 */
public class DateUt {
    public static boolean getTimeCur() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        //Date date=new Date();
        c1.setTime(new Date());//要判断的日期
        c2.setTime(new Date());//初始日期
        c3.setTime(new Date());//也给初始日期 把分钟加五
        c3.add(c3.MINUTE, 5);
        c2.add(c2.MINUTE, -5);//减去五分钟
        if (c1.after(c2) && c1.before(c3)) {
            return false;
        } else {
            return true;
        }
    }
}
