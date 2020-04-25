package com.tim.exception.type;

/**
 * @author：tim
 * @date：20-4-11 上午11:48
 * @description：
 */
public class ServiceException extends CommonException {

  public ServiceException(String msg) {
    super("服务错误：" + msg);
  }
}
