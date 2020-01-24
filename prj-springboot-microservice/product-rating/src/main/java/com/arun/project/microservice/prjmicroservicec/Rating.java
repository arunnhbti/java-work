package com.arun.project.microservice.prjmicroservicec;

public class Rating {
    private String productId;
    private String rating;

    Rating(String productId, String rating) {
        this.productId = productId;
        this.rating = rating;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProductId() {
        return productId;
    }

    public String getRating() {
        return rating;
    }
}
