package com.web.domain;

import lombok.Data;

/**
 * @Author zhourui
 * @Date 2020/5/7 15:33
 */
@Data
public class ResponseEntity<T> extends BaseResponse {

    private T data;
    private Long total;
    private Integer pages;

    public ResponseEntity() {}

    public ResponseEntity(int code, String message) {
        super(code, message);
        this.data = null;
    }
}
