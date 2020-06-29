package com.tim.exception;

import com.tim.exception.type.CommonException;
import com.tim.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：tim
 * @date：20-3-7 下午9:54
 * @description： 统一异常处理。使用controller加强器，捕获异常后，返回json到前端
 */
@ControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

  /**
   * 除业务异常之外的异常处理。未预料异常，需要打印详细错误日志
   */
  @ResponseBody
  @ExceptionHandler(Exception.class)
  public Message otherExceptionHandler(Exception ex) {
    log.error("系统异常：", ex);
    return Message.error("系统异常");
  }

  /**
   * 拦截捕捉业务异常，继承自CommonException的异常。业务异常，一般用于提示用户。业务侧抛出异常时，需要打印详细warning日志
   */
  @ResponseBody
  @ExceptionHandler(CommonException.class)
  public Message bizExceptionHandler(CommonException ex) {
    return Message.error(ex.getMessage());
  }

  /**
   * 拦截输入参数校验异常。输入参数字段上注解，并且控制器有@valid，返回注解上的message
   */
  @ResponseBody
  @ExceptionHandler(BindException.class)
  public Message validExceptionHandler(BindException ex) {
    log.error("参数校验异常：" + ex);
    return Message.error(ex.getFieldError().getDefaultMessage());
  }
}
