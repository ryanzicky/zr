package com.web.enums;

/**
 * @Author zhourui
 * @Date 2020/12/23 15:44
 */
public enum TypeEnum {

    USER(1, "user"),
    MENU(2, "menu"),
    ROLE(3, "role"),
    PERMISSION(4, "permission"),
    USER_ROLE(5, "user_role"),
    ROLE_PERMISSION(6, "role_permission"),
    PERMISSION_MENU(7, "permission_menu");

    private Integer code;
    private String name;

    TypeEnum(Integer code, String name) {
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
