package com.tim.test;

import com.tim.util.DateFormateUtil;
import java.util.Date;
import org.junit.Test;

/**
 * @author：tim
 * @date：20-7-5 上午11:57
 * @description：
 */
public class TestDateUtil {

  @Test
  public void testDate2String() {
    System.out.println(DateFormateUtil.date2String(new Date()));
  }

  @Test
  public void testDateFormate() {
    System.out.println(DateFormateUtil.dateFormat(new Date()));
  }
}
