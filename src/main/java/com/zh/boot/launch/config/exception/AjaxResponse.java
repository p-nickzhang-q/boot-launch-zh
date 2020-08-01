package com.zh.boot.launch.config.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
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
        return AjaxResponse.builder().code(200).isOk(true).data(data).message("成功").build();
    }

    public static AjaxResponse success() {
        return AjaxResponse.builder().code(200).isOk(true).message("成功").build();
    }

    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsOk(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：1375610xxxx进行处理!");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108xxx进行处理!");
        }
        return resultBean;
    }
}
