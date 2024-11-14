package com.manage.util;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName: TimeConverterUtil
 * @Description:  时间转换工具类
 * @author: 舒克、舒克
 * @Date: 2024/11/14 11:28
 */
public class TimeConverterUtil {

    /**
     * 将LocalDateTime对象格式化为指定格式的字符串
     *
     * @param dateTime 要格式化的LocalDateTime对象
     * @param pattern  日期时间格式字符串，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的字符串
     */
    public static String formatLocalDateTime(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * 将LocalDate对象格式化为指定格式的字符串
     *
     * @param date   要格式化的LocalDate对象
     * @param pattern  日期格式字符串，例如 "yyyy-MM-dd"
     * @return 格式化后的字符串
     */
    public static String formatLocalDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * 将LocalDate对象格式化为指定格式的字符串
     *
     * @param date   要格式化的Date对象
     * @param pattern  日期格式字符串，例如 "yyyy-MM-dd"
     * @return 格式化后的字符串
     */
    public static String formatLocalDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }



    /**
     * 将LocalTime对象格式化为指定格式的字符串
     *
     * @param time   要格式化的LocalTime对象
     * @param pattern  时间格式字符串，例如 "HH:mm:ss"
     * @return 格式化后的字符串
     */
    public static String formatLocalTime(LocalTime time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return time.format(formatter);
    }

    /**
     * 将指定格式的字符串解析为LocalDateTime对象
     *
     * @param dateTimeStr 日期时间字符串
     * @param pattern  日期时间格式字符串，需与传入的字符串格式匹配，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 解析后的LocalDateTime对象，如果解析失败会抛出DateTimeParseException异常
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    /**
     * 将指定格式的字符串解析为LocalDate对象
     *
     * @param dateStr 日期字符串
     * @param pattern  日期格式字符串，需与传入的字符串格式匹配，例如 "yyyy-MM-dd"
     * @return 解析后的LocalDate对象，如果解析失败会抛出DateTimeParseException异常
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * 将指定格式的字符串解析为LocalTime对象
     *
     * @param timeStr 时间字符串
     * @param pattern  时间格式字符串，需与传入的字符串格式匹配，例如 "HH:mm:ss"
     * @return 解析后的LocalTime对象，如果解析失败会抛出DateTimeParseException异常
     */
    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(timeStr, formatter);
    }
}
