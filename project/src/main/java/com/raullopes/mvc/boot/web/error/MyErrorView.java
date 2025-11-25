package com.raullopes.mvc.boot.web.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class MyErrorView implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {

        ModelAndView model = new ModelAndView("/error");
        model.addObject("status", status.value());
        switch (status.value()) {
            case 404:
                model.addObject("error", "Page not found.");
                model.addObject("message", "The URL for the page '" + map.get("path") + "' does not exist.");
                break;
            case 500:
                model.addObject("error", "An internal server error occurred.");
                model.addObject("message", "An unexpected error occurred. Please try again later.");
                break;
            default:
                model.addObject("error", map.get("error"));
                model.addObject("message", map.get("message"));
                break;
        }

        System.out.println(map.get("error"));
        System.out.println(map.get("message"));

        return model;
    }

}