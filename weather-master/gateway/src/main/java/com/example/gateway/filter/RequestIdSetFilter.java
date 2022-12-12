package com.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class RequestIdSetFilter implements GlobalFilter, Ordered {


    final Logger logger = LoggerFactory.getLogger(RequestIdSetFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestId = UUID.randomUUID().toString();
        ServerHttpRequest request = exchange.getRequest().mutate().header("REQUEST_ID", requestId).build();
        return chain
                .filter(exchange.mutate().request(request).build())
                .then(Mono.fromRunnable(() -> logger.info("成功生成请求id REQUEST_ID:{}",requestId)));
    }

    @Override
    public int getOrder() {
        return -10;
    }
}
