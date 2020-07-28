package com.zh.boot.launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.entities.Reader;
import org.apache.commons.compress.utils.Sets;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleVO = ArticleVO.builder().id(1L)
                .author("zh").content("test").createTime(System.currentTimeMillis())
                .title("t1").readers(Sets.newHashSet(
                        new Reader("kobe", 20),
                        new Reader("jame", 21)
                )).build();
        String s = objectMapper.writeValueAsString(articleVO);
        System.out.println(s);
        ArticleVO articleVO1 = objectMapper.readValue(s, ArticleVO.class);
        System.out.println(articleVO1);
    }

}
