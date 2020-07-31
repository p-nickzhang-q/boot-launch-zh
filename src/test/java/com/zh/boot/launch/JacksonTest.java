package com.zh.boot.launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.boot.launch.entities.Article;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.entities.Reader;
import org.apache.commons.compress.utils.Sets;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO article = ArticleVO.builder().id(1L)
                .author("zh").content("test").createTime(System.currentTimeMillis())
                .title("t1").readers(Sets.newHashSet(new Reader("kobe", 20),
                        new Reader("jame", 21))).build();
        String s = objectMapper.writeValueAsString(article);
        System.out.println(s);
        Article article1 = objectMapper.readValue(s, Article.class);
        System.out.println(article1);
    }

}
