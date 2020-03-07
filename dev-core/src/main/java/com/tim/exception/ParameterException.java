package com.tim.exception;

/**
 * @author：tim
 * @date：20-3-7 下午10:12
 * @description：
 */
public class ParameterException extends IshouException {

  public ParameterException(String msg) {
    super("参数错误：" + msg);
  }
}
