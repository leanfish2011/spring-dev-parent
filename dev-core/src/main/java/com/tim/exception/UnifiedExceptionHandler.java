package com.tim.exception;

import com.tim.exception.type.CommonException;
import com.tim.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：tim
 * @date：20-3-7 下午9:54
 * @description： 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

  /**
   * 全局异常捕捉处理
   */
  @ResponseBody
  @ExceptionHandler(Exception.class)
  public Message runTimeExceptionHandler(Exception ex) {
    log.error("系统异常：{}", ex.getMessage());
    return Message.error(ex.getMessage());
  }

  /**
   * 拦截捕捉自定义异常 CommonException.class
   */
  @ResponseBody
  @ExceptionHandler(CommonException.class)
  public Message myErrorHandler(CommonException ex) {
    log.error("业务异常：{}", ex.getMessage());
    return Message.error(ex.getMessage());
  }
}
