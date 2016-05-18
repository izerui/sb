package com.sb.hyh.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * api doc:springfox swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements EnvironmentAware {
	private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);
	private RelaxedPropertyResolver propertyResolver;
	/**
	 * 所有url
	 */
	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";
	/**
	 * 筛选展示 /api/二级url
	 */
	public static final String DEFAULT_INCLUDE_PATTERN2 = "/api/.*";

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment);
	}

	@Bean
	public Docket swaggerSpringfoxDocket() {
		log.debug("Starting Swagger");
		// 所有接口
		// System.out.println(PathSelectors.any());

		StopWatch watch = new StopWatch();
		watch.start();
		Docket swaggerSpringMvcPlugin = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class).select()
				.paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();
		watch.stop();

		log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
		return swaggerSpringMvcPlugin;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(propertyResolver.getProperty("title"), propertyResolver.getProperty("description"),
				propertyResolver.getProperty("version"), propertyResolver.getProperty("termsOfServiceUrl"),
				propertyResolver.getProperty("contact"), propertyResolver.getProperty("license"),
				propertyResolver.getProperty("licenseUrl"));
	}

	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("test").genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/")// base,最终调用接口后会和paths拼接在一起
				.select().paths(or(regex(DEFAULT_INCLUDE_PATTERN2)))// 过滤的接口
				.build().apiInfo(testApiInfo());
	}

	private ApiInfo testApiInfo() {
		return new ApiInfo("Electronic Health Record(EHR) Platform API", // 大标题
				"EHR Platform's REST API, all the applications could access the Object model data via JSON.", // 小标题
				"0.1", // 版本
				"NO terms of service", "1023746826@qq.com", // 作者
				"The Apache License, Version 2.0", // 链接显示文字
				"http://www.apache.org/licenses/LICENSE-2.0.html"// 网站链接
		);
	}
}