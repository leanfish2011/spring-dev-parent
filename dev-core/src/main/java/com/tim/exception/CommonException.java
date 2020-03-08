package com.tim.exception;

/**
 * @author：tim
 * @date：20-3-7 下午9:59
 * @description： 系统所有自定义异常父类，用于统一异常处理
 */
public abstract class CommonException extends Exception {

  public CommonException(String msg) {
    super(msg);
  }
}
