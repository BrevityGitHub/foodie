package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author mw
 * @version JDK 8
 * @className Swagger2
 * @date 2022/4/19 18:41
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	// 默认地址：http://localhost:8088/swagger-ui.html
	// 新UI配置地址：https://localhost:8088/doc.html
	/**
	 * 配置swagger2核心配置
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		// 指定api类型
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.imooc.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("电商平台接口API")
				.contact(new Contact("BrevityGitHub",
						"https://www.github.com",
						"brevity.souls@gmail.com"))
				.description("API文档")
				.version("1.0.0")
				.termsOfServiceUrl("https://www.github.com")
				.build();
	}
}
