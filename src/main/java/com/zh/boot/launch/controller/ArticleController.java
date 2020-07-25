package com.zh.boot.launch.controller;

import com.zh.boot.launch.entities.AjaxResponse;
import com.zh.boot.launch.entities.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {


    @PostMapping
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("save:" + article);
        return AjaxResponse.success();
    }

    @GetMapping("/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        Article article = Article.builder().id(id).author("zh").content("test").createTime(System.currentTimeMillis())
                .title("t1").build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    @PutMapping
    public AjaxResponse updateArticle(@RequestBody Article article) {
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
}
