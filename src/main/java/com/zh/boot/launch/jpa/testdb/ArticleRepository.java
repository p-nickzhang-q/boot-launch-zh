package com.zh.boot.launch.jpa.testdb;

import com.zh.boot.launch.jpa.common.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends BaseRepository<Article, Long> {
}
