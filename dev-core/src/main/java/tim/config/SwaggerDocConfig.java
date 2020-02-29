package tim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
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

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage(swaggerBasePackage)).paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(swaggerTitle).version(swaggerVersion).build();
  }
}
