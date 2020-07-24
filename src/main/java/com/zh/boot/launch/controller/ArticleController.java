package com.zh.boot.launch.controller;

import com.zh.boot.launch.entities.AjaxResponse;
import com.zh.boot.launch.entities.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @PostMapping
    public AjaxResponse save(@RequestBody Article article){
        log.info("save:"+article);
        return AjaxResponse.success(article);
    }

}
