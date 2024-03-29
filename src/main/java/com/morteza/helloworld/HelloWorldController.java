package com.morteza.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Morteza");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello %s", name));
    }

    @GetMapping("/hello-world-internationalization")
    public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message", null, locale);
    }

    @GetMapping("/errorr")
    public String error(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("error", null, locale);
    }
}
