package com.tim.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfig {

  /**
   * 文档生成扫描包
   */
  @Value("${swagger.basePackage}")
  private String swaggerBasePackage;

  /**
   * 文档标题
   */
  @Value("${swagger.title}")
  private String swaggerTitle;

  /**
   * 文档版本
   */
  @Value("${swagger.version}")
  private String swaggerVersion;

  // TODO
  // 不需要token接口：POST /api/v1/auth/account/login
  //
  //所有包含"auth"的接口不需要使用securitySchemes
  private String swaggerSecurityPath = "^(?!auth).*$";

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage(swaggerBasePackage))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(securitySchemes())
        .securityContexts(securityContexts());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(swaggerTitle).version(swaggerVersion).build();
  }

  private List<ApiKey> securitySchemes() {
    List apiKeys = new ArrayList<ApiKey>(1);
    apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));

    return apiKeys;
  }

  private List<SecurityContext> securityContexts() {
    List securityContexts = new ArrayList<SecurityContext>(1);
    securityContexts.add(SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.regex(swaggerSecurityPath))
        .build());

    return securityContexts;
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;

    List securityReferences = new ArrayList<SecurityReference>(1);
    securityReferences.add(new SecurityReference("Authorization", authorizationScopes));

    return securityReferences;
  }
}
