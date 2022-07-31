package com.learning.gateway.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        /* Function<PredicateSpec, Buildable<Route>> routeFunction1 =
                predicateSpec -> predicateSpec.path("/get")
                        .filters(f -> f.addRequestHeader("MyHeader", "MyHeaderValue").addRequestParameter("MyParam", "MyParamValue"))
                        .uri("http://httpbin.org:80"); URL can be of any MS */

        //custom route
        return builder.routes().
                route(predicateSpec -> predicateSpec.path("/get")
                        .filters(f -> f.addRequestHeader("MyHeader", "MyHeaderValue").addRequestParameter("MyParam", "MyParamValue"))
                        .uri("http://httpbin.org:80"))
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
                .route(predicateSpec -> predicateSpec.path("/currency-converter/**").uri("lb://currency-conversion-service"))
                .route(predicateSpec -> predicateSpec.path("/currency-converter-feign/**").uri("lb://currency-conversion-service"))
                .route(predicateSpec -> predicateSpec.path("/currency-converter-new/**")
                        .filters(f -> f.rewritePath("/currency-converter-new/(?<segment>.*)", "/currency-converter-feign/${segment}")).uri("lb://currency-conversion-service"))
                .build();
    }
}
