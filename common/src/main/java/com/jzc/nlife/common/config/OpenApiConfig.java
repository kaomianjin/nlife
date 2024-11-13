//package com.jzc.nlife.common.config;
//
//
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import org.springdoc.core.GroupedOpenApi;
//import org.springdoc.core.customizers.OperationCustomizer;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
///**
// * @Description:
// * @author: jzc
// * @version: V1.0
// * @date: 2019/7/9  10:55
// */
//@Configuration
//public class OpenApiConfig {
//
//    @Bean
//    @Profile("!prod")
//    public GroupedOpenApi actuatorApi(OpenApiCustomizer actuatorOpenApiCustomizer,
//                                      OperationCustomizer actuatorCustomizer,
//                                      WebEndpointProperties endpointProperties,
//                                      @Value("${springdoc.version}") String appVersion) {
//        return GroupedOpenApi.builder()
//                .group("Actuator")
//                .pathsToMatch(endpointProperties.getBasePath() + ALL_PATTERN)
//                .addOpenApiCustomizer(actuatorOpenApiCustomizer)
//                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
//                .addOperationCustomizer(actuatorCustomizer)
//                .pathsToExclude("/health/*")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
//        return GroupedOpenApi.builder().group("users")
//                .addOperationCustomizer((operation, handlerMethod) -> {
//                    operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
//                    return operation;
//                })
//                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Users API").version(appVersion)))
//                .packagesToScan("org.springdoc.demo.app2")
//                .pathsToMatch("/user/**")
//                .build();
//    }
//}
//
