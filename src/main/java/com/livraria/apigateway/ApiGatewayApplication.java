package com.livraria.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) { SpringApplication.run(ApiGatewayApplication.class, args); }
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/livro/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://GERENCIAMENTO-LIVRO")

				)
				.route(p -> p
						.path("/api/venda-livro/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://VENDA-LIVRO")
				)
				.build();
	}

}
