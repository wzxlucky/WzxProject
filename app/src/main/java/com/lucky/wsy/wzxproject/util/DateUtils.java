package com.lucky.wsy.wzxproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 一些常用的时间日期处理工具
 * 
 */
public class DateUtils {

	/** yyyy-MM */
	public static final String EN_YYYY_MM = "yyyy-MM";
	/** yyyy-MM-dd */
	public static final String EN_YYYY_MM_DD = "yyyy-MM-dd";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String EN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/** yyyy年MM月 */
	public static final String CH_YYYY_MM = "yyyy年MM月";
	/** yyyy年MM月dd日 */
	public static final String CH_YYYY_MM_DD = "yyyy年MM月dd日";
	/** yyyy年MM月dd日 HH时mm分ss秒 */
	public static final String CH_YYYY_MM_DD_HH_MM_SS = "yyyy年MM月dd日 HH时mm分ss秒";

	/** 默认时区--东八区（北京） */
	public static final TimeZone UTC8 = TimeZone.getTimeZone("GMT+08:00");

	/**
	 * 将日期类型按照指定格式转化为字符串
	 * 
	 * @param date
	 *            日期(为null时，默认当前东八区时间)
	 * @param dateFormat
	 *            指定格式（为null时，默认yyyy-MM-dd）
	 * @return
	 */
	public static String toString(Date date, String dateFormat) {
		if (date == null) { // 日期(为null时，默认当前东八区时间)
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		if (dateFormat == null || dateFormat.equals("")) { // 指定格式（为null时，默认yyyy-MM-dd）
			dateFormat = EN_YYYY_MM_DD;
		}
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		String string = sf.format(date);
		return string;
	}

	/**
	 * 将long型日期按照指定格式转化为字符串
	 * 
	 * @param date
	 *            时间
	 * @param dateFormat
	 *            指定格式（为null时，默认yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static String toString(long date, String dateFormat) {
		if (dateFormat == null || dateFormat.equals("")) { // 指定格式（为null时，默认yyyy-MM-dd
															// HH:mm:ss）
			dateFormat = EN_YYYY_MM_DD_HH_MM_SS;
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(new Date(date));
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		String string = sf.format(c.getTime());
		return string;
	}

	/**
	 * 字符串类型转化为日期类型
	 * 
	 * @param dateStr
	 *            一定格式的字符串
	 * @param dateFormat
	 *            指定格式（为null时，默认yyyy-MM-dd）
	 * @return date
	 */
	public static Date toDate(String dateStr, String dateFormat) {
		if (dateFormat == null || dateFormat.equals("")) { // 指定格式（为null时，默认yyyy-MM-dd）
			dateFormat = EN_YYYY_MM_DD;
		}
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 指定 年 月 日 时 分 秒 或其中几个，获取日期类型
	 * 
	 * @param year
	 *            yyyy
	 * @param month
	 *            MM
	 * @param day
	 *            dd
	 * @param hour
	 *            hh
	 * @param minute
	 *            mm
	 * @param second
	 *            ss
	 * @return
	 */
	public static Date toDate(String year, String month, String day,
			String hour, String minute, String second) {
		String currentYear = getCurrentYear(null); // 当前年份字符串
		String currentMonth = getCurrentMonth(null); // 当前月份字符串
		String currentDay = getCurrentDay(null); // 当前天数字符串
		String currentHour = getCurrentHour(null); // 当前小时字符串
		String currentMinute = getCurrentMinute(null); // 当前分钟字符串
		String currentSecond = getCurrentSecond(null); // 当前秒数字符串
		if (year == null || year.equals("")) { // 如果年为空，默认东八区当前年
			year = currentYear;
		} else if (year.length() == 3) { // 如果年为三位，补当前年前一位
			year = currentYear.substring(0, 1) + year;
		} else if (year.length() == 2) { // 如果年为二位，补当前年前二位
			year = currentYear.substring(0, 2) + year;
		} else if (year.length() == 1) { // 如果年为一位，补当前年前三位
			year = currentYear.substring(0, 3) + year;
		}
		if (month == null || month.equals("")) { // 如果年为空，默认东八区当前年
			month = currentMonth;
		} else if (month.length() == 1) { // 如果月为一位，补当前月第一位
			month = currentMonth.substring(0, 1) + month;
		}
		if (day == null || day.equals("")) { // 如果日为空，默认东八区当前日
			day = currentDay;
		} else if (day.length() == 1) { // 如果日为一位，补当前日第一位
			day = currentDay.substring(0, 1) + day;
		}
		if (hour == null || hour.equals("")) { // 如果小时为空，默认东八区当前小时
			hour = currentHour;
		} else if (hour.length() == 1) { // 如果小时为一位，补当前小时第一位
			hour = currentHour.substring(0, 1) + hour;
		}
		if (minute == null || minute.equals("")) { // 如果分钟为空，默认东八区当前分钟
			minute = currentMinute;
		} else if (minute.length() == 1) { // 如果分钟为一位，补当前分钟第一位
			minute = currentMinute.substring(0, 1) + minute;
		}
		if (second == null || second.equals("")) { // 如果秒数为空，默认东八区当前秒数
			second = currentSecond;
		} else if (second.length() == 1) { // 如果秒数为一位，补当前秒数第一位
			second = currentSecond.substring(0, 1) + second;
		}
		String dateStr = year + "-" + month + "-" + day + " " + hour + ":"
				+ minute + ":" + second;
		Date date = toDate(dateStr, EN_YYYY_MM_DD_HH_MM_SS);
		return date;
	}

	/**
	 * 获取指定时区当前日期字符串
	 * 
	 * @param dateFormat
	 *            返回日期字符串格式,为null时默认EN_YYYY_MM_DD_HH_MM_SS
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return
	 */
	public static String getNow(String dateFormat, TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		if (dateFormat == null) {
			dateFormat = EN_YYYY_MM_DD_HH_MM_SS;
		}
		Calendar c = Calendar.getInstance(timeZone); // 获取指定时区当前时间
		Date time = c.getTime();
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat); // 初始化日期格式
		String currentTime = sf.format(time); // 指定时区当前时间按格式转换为字符串
		return currentTime;
	}

	/**
	 * 获取指定时区当前时间
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return
	 */
	public static Date getDate(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone); // 获取指定时区当前时间
		Date time = c.getTime();
		return time;
	}

	/**
	 * 获取指定时区当前年字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return yyyy
	 */
	public static String getCurrentYear(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String year = String.valueOf(c.get(Calendar.YEAR));
		return year;
	}

	/**
	 * 获取指定时区当前月份字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return MM(不足10,在前面补0)
	 */
	public static String getCurrentMonth(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String month = String.valueOf(c.get(Calendar.MONTH) + 1).length() == 2 ? String
				.valueOf(c.get(Calendar.MONTH) + 1) : "0"
				+ String.valueOf(c.get(Calendar.MONTH) + 1);
		return month;
	}

	/**
	 * 获取指定时区当前天字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return dd(不足10,在前面补0)
	 */
	public static String getCurrentDay(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length() == 2 ? String
				.valueOf(c.get(Calendar.DAY_OF_MONTH)) : "0"
				+ String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		return day;
	}

	/**
	 * 获取指定时区当前小时字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return HH(不足10,在前面补0)
	 */
	public static String getCurrentHour(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 2 ? String
				.valueOf(c.get(Calendar.HOUR_OF_DAY)) : "0"
				+ String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		return hour;
	}

	/**
	 * 获取指定时区当前分钟字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return mm(不足10,在前面补0)
	 */
	public static String getCurrentMinute(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String minute = String.valueOf(c.get(Calendar.MINUTE)).length() == 2 ? String
				.valueOf(c.get(Calendar.MINUTE)) : "0"
				+ String.valueOf(c.get(Calendar.MINUTE));
		return minute;
	}

	/**
	 * 获取指定时区当前秒字符串
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return ss(不足10,在前面补0)
	 */
	public static String getCurrentSecond(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		Calendar c = Calendar.getInstance(timeZone);
		String second = String.valueOf(c.get(Calendar.SECOND)).length() == 2 ? String
				.valueOf(c.get(Calendar.SECOND)) : "0"
				+ String.valueOf(c.get(Calendar.SECOND));
		return second;
	}

	/**
	 * 获取指定时区当前星期
	 * 
	 * @param timeZone
	 *            时区，默认东八区(null)
	 * @return 星期日，星期一，星期二，星期三，星期四，星期五，星期六
	 */
	public static String getCurrentWeekday(TimeZone timeZone) {
		if (timeZone == null) {
			timeZone = UTC8;
		}
		String[] week = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar c = Calendar.getInstance(timeZone);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String weekday = week[dayOfWeek - 1];
		return weekday;
	}

	/**
	 * 获取指定日期加秒钟后日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param second
	 *            移动秒钟，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveSecond(Date date, int second) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.SECOND, second);
		return c.getTime();
	}

	/**
	 * 获取指定日期加分钟后日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param minute
	 *            移动分钟，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveMinute(Date date, int minute) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	/**
	 * 获取指定日期加小时候日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param hours
	 *            移动小时，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveHour(Date date, int hours) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, hours);
		return c.getTime();
	}

	/**
	 * 获取指定日期加days天后日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param days
	 *            移动天数，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveDay(Date date, int days) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, days);
		return c.getTime();
	}

	/**
	 * 获取指定日期加months月后日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param months
	 *            移动月数，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveMonth(Date date, int months) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	/**
	 * 获取指定日期加years年后日期
	 * 
	 * @param date
	 *            指定日期，为null，默认当前
	 * @param years
	 *            移动年数，正数向后移动，负数向前移动
	 * @return
	 */
	public static Date dateMoveYear(Date date, int years) {
		if (date == null) { // 日期为空，默认当前时间
			Calendar c = Calendar.getInstance(UTC8); // 获取指定时区当前时间
			date = c.getTime();
		}
		Calendar c = Calendar.getInstance(UTC8);
		c.setTime(date);
		c.add(Calendar.YEAR, years);
		return c.getTime();
	}
	
	
		/**
	 * 获取当前时间的小时数
	 * 
	 * @return int 小时
	 */
	public static int getCurrentHour(){
		long time=System.currentTimeMillis();
		final Calendar mCalendar=Calendar.getInstance();
		mCalendar.setTimeInMillis(time);
		return mCalendar.get(Calendar.HOUR_OF_DAY);

	}
	
	/**
	 * 获取当前时间的分钟
	 * 
	 * @return int 分
	 */
	public static int getCurrentMin(){
		long time=System.currentTimeMillis();
		final Calendar mCalendar=Calendar.getInstance();
		mCalendar.setTimeInMillis(time);
		return mCalendar.get(Calendar.MINUTE);
	}
	
	/**
	 * 获取当前时间的秒
	 * 
	 * @return int 秒
	 */
	public static int getCurrentSec(){
		long time=System.currentTimeMillis();
		final Calendar mCalendar=Calendar.getInstance();
		mCalendar.setTimeInMillis(time);
		return mCalendar.get(Calendar.SECOND);
	}
	
	/**
	 * 分钟转换小时（整数值）
	 * 
	 * @param minuter
	 * @return int 小时
	 */
	public static int minCastToHour(int minuter){
		return minuter/60;
	}
	
	/**
	 * 分钟转换小时（求余值）
	 * 
	 * @param minuter
	 * @return int 求余值
	 */
	public static int minCastToHourMore(int minuter){
		return minuter%60;
	}
	
	/**
	 * 小时转换分钟
	 * 
	 * @param hour
	 * @return int 分钟
	 */
	public static int hourCastToMin(int hour){
		return hour*60;
	}

}
