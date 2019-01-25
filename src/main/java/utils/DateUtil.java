package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/1/25
 * Description:
 * Modified:
 */
public class DateUtil {

    /**
     * 转换时间为字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getDateToString(Date date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        return f.format(date);
    }

    /**
     * 把时间转化成pattern格式字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateToString(Date date, String pattern) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        return f.format(date);
    }


    /**
     * 把 yyyy-MM-dd HH:mm:ss 形式的字符串转换为时间
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date getStringToDate(String str) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        Date d = f.parse(str);
        return d;
    }

    /**
     * 把 pattern 形式的字符串转换为时间
     * @param str
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date getStringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        Date d = f.parse(str);
        return d;
    }

    //获取两个时间差(以月为单位)
    public static int getMonthInterval(Date startTime, Date endTime) {
        Calendar starCal = Calendar.getInstance();
        starCal.setTime(startTime);
        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endTime);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);
        return ((eYear - sYear) * 12 + (eMonth - sMonth));
    }

    //获取两个时间差(以天为单位)
    public static long getDayInterval(Date startTime, Date endTime) {
        long time = endTime.getTime() - startTime.getTime();
        long interval = time / (1000 * 60 * 60 * 24);
        return interval;
    }

    //获取当前时间月末最后一天最晚的时间(23点59分59秒)
    public static Date getCurMonLastTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    //获取当前时间下个月第一天的最早时间(零时、零分、零秒)
    public static Date getNextMonFirstTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    // 获得今天的最后一秒
    public static Date getCurDayLastTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }


}
