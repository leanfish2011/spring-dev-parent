package com.tim.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author：tim
 * @date：20-3-8 下午12:40
 * @description：FeignClient配置类
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {

  /**
   * 原http请求中header信息加入到feignclient，携带原信息访问其他服务接口
   */
  public void apply(RequestTemplate requestTemplate) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    if (attributes == null) {
      return;
    }
    HttpServletRequest request = attributes.getRequest();
    if (request == null) {
      return;
    }

    Enumeration<String> headerNames = request.getHeaderNames();
    if (headerNames != null) {
      while (headerNames.hasMoreElements()) {
        String name = headerNames.nextElement();
        String values = request.getHeader(name);
        requestTemplate.header(name, values);
      }
    }
  }
}
