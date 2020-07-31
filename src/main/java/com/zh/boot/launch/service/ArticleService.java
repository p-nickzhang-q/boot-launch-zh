package com.zh.boot.launch.service;

import com.zh.boot.launch.entities.Article;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.mapper.ArticleMapper;
import com.zh.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    Mapper dozerMapper;

    @Autowired
    ArticleMapper articleMapper;

    //新增
    
    public void saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);
    }

    //删除
    
    public void deleteArticle(Long id) {
        articleMapper.deleteById(id);
    }

    //更新
    
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateById(articlePO);
    }

    //查询
    
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectById(id),ArticleVO.class);
    }

    //查询所有
    
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectList(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }

}
