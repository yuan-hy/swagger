package com.yuanhy.demoswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
/**
 * @author yuanhy
 * @date 2020-12-19 16:30
 */
@Configuration
@EnableOpenApi //开启 Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docketA() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docketA");
    }

    @Bean
    public Docket docketB() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docketB");
    }

    @Bean
    public Docket docketC() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("docketC");
    }
    @Bean
    public Docket docket(Environment environment){
        //需求 当配置为生产环境 prod，不允许开启 Swagger ，当为开发环境 dev，允许开启 Swagger
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("yuanhy")
                //enable 为 false 表示不启用 Swagger
                .enable(flag)
                .select()
                /**RequestHandlerSelectors 配置要扫描的接口方式
                 * basePackage 扫描的包
                 * 调用 any方法，表示扫描所有接口
                 * 调用 none 方法，表示所有接口不扫描
                 * withMethodAnnotation 基于方法注解扫描 （GetMapping.class）
                 * withClassAnnotation 基于Class 注解扫描 (RestController.class)
                 * **/
                .apis(RequestHandlerSelectors.basePackage("com.yuanhy.demoswagger.controller"))
                //在 apis 基础上过滤
                //.paths(PathSelectors.ant("/yuanhy"))
                .build();
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("yuanhy", "http://localhost:8080/swagger-ui/index.html", "xxx@163.com");
        return new ApiInfo(
                "yuanhy Swagger Api 文档",
                "Api Documentation",
                "v1.0",
                "http://localhost:8080/swagger-ui/index.html",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
