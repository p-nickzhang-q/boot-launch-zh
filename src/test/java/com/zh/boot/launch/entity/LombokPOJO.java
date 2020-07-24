package com.zh.boot.launch.entity;

import lombok.Builder;

@Builder
public class LombokPOJO {

    private String name;
    private Integer age;

    public static void main(String[] args) {
        LombokPOJO zh = LombokPOJO.builder().name("zh").age(10).build();
    }
}


