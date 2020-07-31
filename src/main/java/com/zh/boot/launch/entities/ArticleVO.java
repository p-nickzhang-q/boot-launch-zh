package com.zh.boot.launch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArticleVO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long createTime;

    private Set<Reader> readers = new HashSet<>();
}
