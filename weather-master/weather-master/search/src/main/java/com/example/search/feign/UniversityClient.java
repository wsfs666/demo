package com.example.search.feign;

import com.example.common.domain.GeneralResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "university-service")
public interface UniversityClient {

    @GetMapping("/student/findStus")
    public GeneralResponse findAllStus();
}
