package com.tim.exception.type;

/**
 * @author：tim
 * @date：20-3-7 下午9:59
 * @description： 系统所有自定义异常父类，用于统一异常处理。继承自运行时异常，可以不用声明异常
 */
public abstract class CommonException extends RuntimeException {

  public CommonException(String msg) {
    super(msg);
  }
}
