package com.zh.boot.launch.config.exception;

public enum CustomExceptionType {
    //用户输入异常
    USER_INPUT_ERROR(400, "用户输入异常"),
    SYSTEM_ERROR(500, "系统服务异常"),
    OTHER_ERROR(999, "其他未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    /**
     * 异常类型中文描述
     */
    private final String typeDesc;
    /**
     * code
     */
    private final int code;

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}