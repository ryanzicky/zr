package com.web.enums;

/**
 * @Author zhourui
 * @Date 2020/12/23 15:48
 */
public enum ResponseEnum {

    PARAM_NULL(100, "参数为空"),
    SUCCESS(200, "请求成功"),
    FAIL(400, "请求失败"),
    SYSTEM_ERROR(500, "系统处理异常");

    private Integer code;
    private String name;

    ResponseEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
