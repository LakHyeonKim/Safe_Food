package com.ssafy.rest;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY API")
				.description("SSAFY API Reference for Developers")
				.termsOfServiceUrl("https://edu.ssafy.com")
				.contact(
						new Contact("Ha Seung Hyun", "https://edu.ssafy.com",
								"ssafy@ssafy.com"))
				.license("SSAFY License 0.9")
				.licenseUrl("https://edu.ssafy.com/license.html")
				.version("0.9")
				.build();
	}
}


// http://localhost:8080/swagger-ui.html swagger 접속 페이지
// http://localhost:9999/swagger-ui.html 성공...확인바람..위에 세팅이 잘되면 이게 나타난다.