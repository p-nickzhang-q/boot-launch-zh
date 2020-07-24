package com.zh.boot.launch;

import com.zh.boot.launch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
public class ArticleRestControllerTest {

    private static MockMvc mockMvc;

    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void save() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": " + System.currentTimeMillis() + ",\n" +
                "    \"readers\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(article)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(18))
                .andDo(System.out::println)
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }

}
