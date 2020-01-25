package com.arun.project.microservice.prjmicroserviceb;

import com.arun.project.microservice.product.catalog.configuration.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Configuration.class)
class CatalogTests {

	@Test
	void contextLoads() {
	}

}
