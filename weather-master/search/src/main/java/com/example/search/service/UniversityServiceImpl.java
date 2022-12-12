package com.example.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
@Service
public class UniversityServiceImpl implements UniversityService{

    private final ExecutorService pool;
    private final RestTemplate ribbonRestTemplate;

    @Autowired
    public UniversityServiceImpl(ExecutorService pool, RestTemplate ribbonRestTemplate) {
        this.pool = pool;
        this.ribbonRestTemplate = ribbonRestTemplate;
    }

    @Override
    public Map fetchAllTeacherInfoBySid(){



              CompletableFuture r=      CompletableFuture.supplyAsync(
                            () -> ribbonRestTemplate.getForObject("http://university-service/student/findStus" ,HashMap.class)
                            , pool
                    );



        return CompletableFuture.allOf(r)
                .thenApply(VOID -> (Map)r.join()).join();

    }
}
