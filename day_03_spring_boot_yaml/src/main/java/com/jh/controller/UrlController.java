package com.jh.controller;

import com.jh.model.UrlModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("url")
public class UrlController {
    @Resource
    private UrlModel urlModel;

    @GetMapping
    public Object testUrl(){
        return urlModel;
    }
}
