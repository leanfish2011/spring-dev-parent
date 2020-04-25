package com.tim.exception.type;

/**
 * @author：tim
 * @date：20-3-7 下午10:12
 * @description：
 */
public class ParameterException extends CommonException {

  public ParameterException(String msg) {
    super("参数错误：" + msg);
  }
}
