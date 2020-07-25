package com.zh.boot.launch.entities;

import lombok.Data;

@Data
public class Child
{

  private String name;

  private Integer age;

  private Friend[] friends;
}
