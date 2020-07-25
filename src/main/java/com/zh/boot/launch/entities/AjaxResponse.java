package com.zh.boot.launch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AjaxResponse {

    private Boolean isOk;
    private Integer code;
    private String message;
    private Object data;

    public static AjaxResponse success(Object data) {
        return AjaxResponse.builder().code(200).isOk(true).message("成功").data(data).build();
    }

    public static AjaxResponse success() {
        return AjaxResponse.builder().code(200).isOk(true).message("成功").build();
    }
}
