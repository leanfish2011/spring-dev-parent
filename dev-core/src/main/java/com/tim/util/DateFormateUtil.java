package com.tim.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author：tim
 * @date：20-7-5 上午11:54
 * @description：
 */
public class DateFormateUtil {

  /**
   * 日期格式化
   */
  public static String date2String(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    return simpleDateFormat.format(date);
  }

  /**
   * 格式化年月日
   */
  public static String dateFormat(Date date) {
    DateFormat dateFormat = DateFormat.getDateInstance();

    return dateFormat.format(date);
  }
}
