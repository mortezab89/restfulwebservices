package com.morteza;

import org.h2.engine.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class RestfulWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebApplication.class);
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSourceForMessagesFile(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages","errors");
        messageSource.setDefaultEncoding("UTF-8");

        Set<String> basenameSet = messageSource.getBasenameSet();
        return messageSource;
    }

//    public ResourceBundleMessageSource resourceBundleMessageSourceForErrorFile(){
//        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
//        resourceBundleMessageSource.setBasename("classpath:errors");
//        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
//        return resourceBundleMessageSource;
//    }

}
