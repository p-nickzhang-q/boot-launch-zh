package com.zh.boot.launch.service;

import com.zh.boot.launch.jpa.testdb.Article;
import com.zh.boot.launch.jpa.testdb2.Message;
import com.zh.boot.launch.jpa.testdb2.MessageRepository;
import com.zh.boot.launch.service.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends BaseService<Article, Long> {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public <S extends Article> S save(S s) {
        messageRepository.save(Message.builder()
                .name("kobe").content("test").build());
        return super.save(s);
    }
}
