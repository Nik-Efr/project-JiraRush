package com.javarush.jira.common.internal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(@RequestParam(value = "lang", required = false) Locale locale) {
        return "index";
    }
}