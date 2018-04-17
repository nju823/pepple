package nju.edu.cn.pepple.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cong on 2018-03-23.
 * 解析时间戳
 */
public class TimeUtil {

    private static final String DATE_FOMART="yyyy-MM-dd";

    private static final String HOUR_FORMAT="HH";

    private static final String SECOND_FORMAT="HH:mm:ss";

    private static final int ONE_DAY=1000*60*60*24;

    private static final long ONE_MONTH=1000l*60*60*24*30;


    public static String yesterday(){
        Date date=new Date();
        date.setTime(date.getTime()-ONE_DAY);
        SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_FOMART);
        return dateFormat.format(date);
    }

    public static String lastWeek(String day){
        SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_FOMART);
        Date date= null;
        try {
            date = dateFormat.parse(day);
            date.setTime(date.getTime()-ONE_DAY*7);
            return dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String lastMonth(String day){
        SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_FOMART);
        Date date= null;
        try {
            date = dateFormat.parse(day);
            date.setTime(date.getTime()-ONE_MONTH);
            return dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取小时数，second格式 hh:mm:ss
     * @param second
     * @return
     */
    public static int getHour(String second){
        String hour=second.split(":")[0];
        return Integer.parseInt(hour);
    }

    /**
     * 获取timestamp的日期
     * @param timestamp
     * @return
     */
    public static String getDate(long timestamp){
        return getFormatString(timestamp,DATE_FOMART);
    }

    /**
     * 获取timestamp的小时数 0-23
     * @param timestamp
     * @return
     */
    public static int getHour(long timestamp){
        return Integer.parseInt(getFormatString(timestamp,HOUR_FORMAT));
    }

    /**
     * 获取timestamp的秒数 13:56:45
     * @param timestamp
     * @return
     */
    public static String getSecond(long timestamp){
        return getFormatString(timestamp,SECOND_FORMAT);
    }

    private static String getFormatString(long timestamp,String format){
        Date date=new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static void main(String[] args){
        System.out.println(lastWeek("2017-08-09")+" "+lastMonth("2019-09-09"));

    }


}
