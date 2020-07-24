package com.zh.boot.launch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Long createTime;
    private Set<Reader> readers;

}
