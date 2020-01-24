package com.arun.project.microservice.prjmicroserviceb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Product {

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductItem getProduct(@PathVariable("productId") String productId) {
        ProductItem productItem = new ProductItem(productId, "Product_00001");
        String rating = RestClient.getInstance().get("http://localhost:8081/review/" + productId);
        return productItem;
    }
}
