package com.zh.boot.launch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nickzhang
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArticleVO {
    private Long id;
    @NotNull(message = "作者不能为null")
    @NotEmpty(message = "作者不能为空字符串")
    private String author;
    private String title;
    private String content;
    private Long createTime;

    private Set<Reader> readers = new HashSet<>();
}
