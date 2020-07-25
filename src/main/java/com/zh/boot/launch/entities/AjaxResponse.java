package com.zh.boot.launch.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@ApiModel("通用相应数据结构")
public class AjaxResponse {

    @ApiModelProperty("是否请求成功")
    private Boolean isOk;
    @ApiModelProperty(value = "相应状态码", example = "200,400,500")
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
