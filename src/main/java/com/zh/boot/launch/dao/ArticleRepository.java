package com.zh.boot.launch.dao;

import com.zh.boot.launch.dao.common.BaseRepository;
import com.zh.boot.launch.entities.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends BaseRepository<Article, Long> {
}
