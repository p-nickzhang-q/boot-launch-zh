package com.zh.boot.launch.controller;

import com.zh.boot.launch.config.exception.AjaxResponse;
import com.zh.boot.launch.entities.ArticleVO;
import com.zh.boot.launch.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HelloController {

    @Resource
    ExceptionService exceptionService;

    //private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public ArticleVO hello() {
        /*ArticleRestService article = new ArticleRestService(1L,"zimug");

        article.setAuthor("字母哥");*/

        ArticleVO article1 = ArticleVO.builder().id(3L).author("莫言").build();

        log.info("测试一下" + article1);

        return article1;
    }


    @RequestMapping("/ex/system")
    public AjaxResponse system() {

        exceptionService.systemBizError();

        return AjaxResponse.success();
    }


    @RequestMapping("/ex/user")
    public AjaxResponse user(Integer input) {

        return AjaxResponse.success(exceptionService.userBizError(input));
    }

}
