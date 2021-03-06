package com.zh.boot.launch.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {

    @TableId
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long createTime;

}
