package com.zh.boot.launch.controller;

import com.zh.boot.launch.entities.AjaxResponse;
import com.zh.boot.launch.entities.Article;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.exceptions.NotFoundException;
import com.zh.boot.launch.service.ArticleService;
import com.zh.boot.launch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;
    @Autowired
    private DozerBeanMapper mapper;

    @PostMapping
    public AjaxResponse saveArticle(@RequestBody ArticleVO articleVO) {
        Article article = mapper.map(articleVO, Article.class);
        Article save = service.save(article);
        return AjaxResponse.success(mapper.map(save, ArticleVO.class));
    }

    @GetMapping("/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        Article article = service.findById(id).orElseThrow(NotFoundException::new);
        return AjaxResponse.success(mapper.map(article, ArticleVO.class));
    }

    @PutMapping
    public AjaxResponse updateArticle(@RequestBody ArticleVO articleVO) {
        service.save(mapper.map(articleVO, Article.class));
        return AjaxResponse.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        service.deleteById(id);
        return AjaxResponse.success();
    }

    @GetMapping
    public AjaxResponse getAll() {
        List<Article> all = service.findAll();
        return AjaxResponse.success(DozerUtils.mapList(all, ArticleVO.class));
    }
}
