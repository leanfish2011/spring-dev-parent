package com.tim.exception;

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
    log.error("发生运行时异常：{}", ex.getMessage());
    return Message.error("系统内部错误");
  }

  /**
   * 拦截捕捉自定义异常 IshouException.class
   */
  @ResponseBody
  @ExceptionHandler(IshouException.class)
  public Message myErrorHandler(IshouException ex) {
    log.error("发生业务异常：{}", ex.getMessage());
    return Message.error(ex.getMessage());
  }
}
