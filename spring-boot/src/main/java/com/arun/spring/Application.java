package com.arun.spring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    {
        return args -> {
            System.out.println("| Starting App.");
            Arrays.stream(ctx.getBeanDefinitionNames()).map(bean0 -> bean0.toUpperCase()).forEach(bean1 -> System.out.println(bean1));
        };
    }
}
