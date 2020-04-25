package com.tim.message;

import lombok.Data;

/**
 * 封装返回前端消息，可以带数据实体
 *
 * @author tim
 * @time 2018-04-15 21:45:05
 */
@Data
public class Message<T> {

  /**
   * 状态码
   */
  private Integer code;

  /**
   * 消息提示
   */
  private String msg;

  /**
   * 消息体
   */
  private T data;

  public Message() {
  }

  public Message(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Message(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static Message success() {
    return new Message(MainCode.SUCCESS, MainCode.SUCCESS_MSG);
  }

  public static Message success(String msg) {
    return new Message(MainCode.SUCCESS, msg);
  }

  public static <T> Message<T> success(String msg, T data) {
    return new Message(MainCode.SUCCESS, msg, data);
  }

  public static <T> Message<T> success(T data) {
    return new Message(MainCode.SUCCESS, MainCode.SUCCESS_MSG, data);
  }

  public static Message error(String msg) {
    return new Message(MainCode.FAIL, msg);
  }

  public static Message error() {
    return new Message(MainCode.FAIL, MainCode.FAIL_MSG);
  }

}
