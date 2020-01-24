package com.arun.project.microservice.prjmicroservicec;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class Review {

    @RequestMapping("/{productId}")
    public Rating getRating(@PathVariable("productId") String productId) {
        return new Rating(productId, "4/5");
    }
}
