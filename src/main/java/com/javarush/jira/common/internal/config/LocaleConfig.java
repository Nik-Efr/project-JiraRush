package com.javarush.jira.common.internal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class LocaleConfig {
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(java.util.Locale.ENGLISH);
        resolver.setCookieName("locale");
        resolver.setCookieMaxAge(3600 * 24 * 30);
        return resolver;
    }
}