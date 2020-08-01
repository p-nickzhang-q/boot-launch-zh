package com.zh.boot.launch.controller;

import com.zh.boot.launch.config.exception.AjaxResponse;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        articleService.saveArticle(article);
        return AjaxResponse.success();
    }

    @GetMapping("/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        ArticleVO article = articleService.getArticle(id);
        return AjaxResponse.success(article);
    }

    @GetMapping
    public AjaxResponse getAllArticles() {
        List<ArticleVO> all = articleService.getAll();
        return AjaxResponse.success(all);
    }

    @PutMapping
    public AjaxResponse updateArticle(@RequestBody ArticleVO article) {
        articleService.updateArticle(article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return AjaxResponse.success();
    }
}
