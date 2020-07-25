package com.zh.boot.launch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
/**
 * json数据排序
 */
@JsonPropertyOrder(value = {})
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    /**
     * 忽略属性
     */
    @JsonIgnore
    private Long createTime;
    /**
     * 为null的话不返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Reader> readers;

}
