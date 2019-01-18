package com.battery.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;

public class MyDateUtils {
	private static String[] pattern = new String[] { "yy.MM.dd", "yyyy.MM.dd", "yyyy-MM", "yyyyMM", "yyyy/MM",
			"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss" };

	public static final SimpleDateFormat DEFAULT_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat DEFAULT_EXCEL_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static final SimpleDateFormat DEFAULT_DAY_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date parseDate(String dateStr) {
		try {
			if (dateStr == null || dateStr.trim().length() == 0) {
				return null;
			}
			return DateUtils.parseDate(dateStr, pattern);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getDateString(Date d) {
		return getDateString(d,DEFAULT_FORMATTER);
	}
	
	public static String getDateDayString(Date d) {
		return getDateString(d,DEFAULT_DAY_FORMATTER);
	}

	public static String getDateString(Date d, String formatStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		return getDateString(d,formatter);
	}
	
	public static String getDateString(Date d,SimpleDateFormat formatter) {
		if (d == null) {
			return null;
		}
		String dateString = formatter.format(d);
		return dateString;
	}

	public static String diffDays(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return "";
		}
		String result = "";
		long diffTime = Math.abs(d1.getTime() - d2.getTime()) / 1000;
		if (diffTime < 24 * 60 * 60) {
			result = diffTime / (24 * 60 * 60) + "天";
		} else {
			long diffDays = diffTime / (24 * 60 * 60);
			if (diffDays < 31) {
				result = diffDays + "天";
			} else {
				if (diffDays / 365 > 0) {
					result = diffDays / 365 + "年" + (diffDays % 365) / 30 + "月";
				} else {
					result = (diffDays % 365) / 30 + "月";
				}
			}
		}
		return result;
	}

	public static Date getDiffTime(long diffTime) {
		Date n = new Date();
		return new Date(n.getTime() + diffTime);
	}

	/**
	 * 获取指定日期当月第一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getFirstDay(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 得到给定时间相差 diffMonth 个月的1号0点0分0秒
	 * 
	 * @param currentDate
	 * @param diffMonth
	 * @return
	 */
	public static Date getFirstDayDiffMonth(Date d, int diffMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MONTH, diffMonth);
		c.set(Calendar.DAY_OF_MONTH, 1);
		// 将小时至0
		c.set(Calendar.HOUR_OF_DAY, 0);
		// 将分钟至0
		c.set(Calendar.MINUTE, 0);
		// 将秒至0
		c.set(Calendar.SECOND, 0);
		// 将毫秒至0
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date add(Date d, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	public static int diffMonths(Date startDate, Date endDate) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		return diffMonth;
	}

	public static long diffTime(Date startDate, Date endDate, int field) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		switch (field) {
		case Calendar.DATE:
			return day;
		case Calendar.HOUR:
			return hour;
		case Calendar.MINUTE:
			return min;
		}
		return 0;

	}
	
	/**
	 * 得到两个日期相差都少天，忽略时分秒
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long diffDateIgnoreHMS(Date startDate, Date endDate) {
		long nd = 1000 * 24 * 60 * 60;
		// 获得两个时间的毫秒时间差异
		long diff = parseDate(getDateString(endDate,"yyyy-MM-dd")).getTime() - parseDate(getDateString(startDate,"yyyy-MM-dd")).getTime();
		// 计算差多少天
		long day = diff / nd;
		return day;
	}
	
	/**
	 * 时间格式转换
	 * @param d
	 * @return
	 */
	public static Date getDate(Date d) {
		if (d == null) {
			return null;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(d);
		Date parse = null;
		try {
			parse = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parse;

	}
	
	/**
	 * 获取离当前时间的多少个月时间
	 * @param startDate 当前时间
	 * @param number 多少个月
	 * @return
	 */
	public static Date getDiffMonth(Date startDate ,Integer number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, number);
		Date time = calendar.getTime();

		return time;
		
	}
	
	/**
	 * 获取离当前时间的多少个多少个小时
	 * @param startDate 时间
	 * @param number 多少个小时
	 * @return
	 */
	public static Date getDiffHour(Date startDate ,Integer number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.HOUR, number);
		Date time = calendar.getTime();

		return time;
		
	}
	
	/**
	 * 获取昨天零点
	 * @return
	 */
	public static Date getYesterdayZero(int number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, number);
		Date time = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String format = sdf.format(time);
		Date parse;
		try {
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			parse = sdf2.parse(format);
			return parse;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	//获取前天23:50时间
	public static Date getYesterday2350() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -2);
		Date time = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:50:00");
		String format = sdf.format(time);
		System.out.println(format);
		Date parse;
		try {
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			parse = sdf2.parse(format);
			return parse;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 或取离设点时间多少分钟
	 * @param startDate
	 * @param number
	 * @return
	 */
	public static Date getDiffMinute(Date startDate ,Integer number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MINUTE, number);
		Date time = calendar.getTime();

		return time;
		
	}
	

	/**
	 * 获取整秒的当前时间
	 * @return
	 */
	public static Date getWholeSecondTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 或取离设点时间多少天
	 * @param startDate
	 * @param number
	 * @return
	 */
	public static String getDiffDay(Date startDate ,Integer number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, number);
		Date time = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String format = sdf.format(time);
		return format;
		
	}
	
	/**
	 * 获取当天整点时间
	 * @return
	 */
	public static Date getMorning(Integer hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 获取某个月的开始时间
	 * @param date
	 * @return
	 */
	public static Date  getSupportBeginDayofMonth(Date date) {
		   Calendar startDate = Calendar.getInstance();
		   startDate.setTime(date);
		   startDate.set(Calendar.DAY_OF_MONTH, 1);
		   startDate.set(Calendar.HOUR_OF_DAY, 0);
		   startDate.set(Calendar.MINUTE, 0);
		   startDate.set(Calendar.SECOND, 0);
		   startDate.set(Calendar.MILLISECOND, 0);
		   Date firstDate = startDate.getTime();
		   return firstDate;
	}
	/**
	 * 获取某个月的最后时间
	 * @param date
	 * @return
	 */
	 public static Date getSupportEndDayofMonth(Date date) {
		   Calendar startDate = Calendar.getInstance();
		   startDate.setTime(date);
		   startDate.set(Calendar.DAY_OF_MONTH, startDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		   startDate.set(Calendar.HOUR_OF_DAY, 23);
		   startDate.set(Calendar.MINUTE, 59);
		   startDate.set(Calendar.SECOND, 59);
		   startDate.set(Calendar.MILLISECOND, 999);
		   Date firstDate = startDate.getTime();
		   return firstDate;
		 }
	/**
	 * 格式化日期将时分秒设置为23:59:59
	 * @param date
	 * @return
	 */
	public static Date formartDate23_59_59(Date date) {
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(date);
		startDate.set(Calendar.HOUR_OF_DAY, 23);
		startDate.set(Calendar.MINUTE, 59);
		startDate.set(Calendar.SECOND, 59);
		Date firstDate = startDate.getTime();
		return firstDate;
	}
}
