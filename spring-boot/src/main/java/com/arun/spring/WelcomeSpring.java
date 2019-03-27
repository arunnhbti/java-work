package com.arun.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeSpring
{
    @RequestMapping("/")
    public String get()
    {
        return "Welcome";
    }
}
