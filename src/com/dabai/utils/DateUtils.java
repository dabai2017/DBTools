package com.dabai.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期时间工具类
 * @author 故事与猫
 *
 */
public class DateUtils{

    /**
     * 获取指定类型的当前时间
     * @param i
     * @return
     */

    public static String getNowTime(int i) {
        String time = null;
        SimpleDateFormat sdf;
        switch (i) {
            case 1:
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                time = sdf.format(new Date());
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
                time = sdf.format(new Date());
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                time = sdf.format(new Date());
                break;
            case 4:
                sdf = new SimpleDateFormat("yyyyMMddhhmmss");
                time = sdf.format(new Date());
                break;
            case 5:
                sdf = new SimpleDateFormat("hh:mm");
                time = sdf.format(new Date());
                break;
            case 6:
                sdf = new SimpleDateFormat((Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 12 ? "下午":"上午")+"hh:mm");
                time = sdf.format(new Date());
                break;
            case 7:
                sdf = new SimpleDateFormat("HH:mm");
                time = sdf.format(new Date());
                break;
            default:
                time = new Date().toString();
                break;
        }
        return time;
    }


    /**
     * 获取指定格式的当前时间
     * @param pattern
     * @return
     */
    public static String getNowTime(String pattern) {
   
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }


    /**
     * 获取 指定格式化的指定时间
     * @param time
     * @return
     */
    public static String getTime(String pattern,long time) {
        return new SimpleDateFormat(pattern).format(time);
    }


}
