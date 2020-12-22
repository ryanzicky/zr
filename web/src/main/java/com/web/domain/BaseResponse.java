package com.web.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author zhourui
 * @Date 2020/5/7 15:29
 */
@Data
@Slf4j
public class BaseResponse {

    private boolean success;
    private long code;
    private String msg;

    public BaseResponse() {}

    public static <E extends BaseResponse> E buildBaseResp(boolean success, long code, String message, Class<E> cls) {
        BaseResponse e = null;

        try {
            e = (BaseResponse)cls.newInstance();
        } catch (InstantiationException var6) {
            log.warn("");
        } catch (IllegalAccessException var7) {
            log.warn("");
        }

        e.setSuccess(success);
        e.setCode(code);
        e.setMsg(message);
        return (E) e;
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <E extends BaseResponse> E success(Class<E> cls) {
        return buildBaseResp(true, 200L, "请求成功", cls);
    }

    public static <E extends BaseResponse> E failure(Class<E> cls) {
        return buildBaseResp(false, 500L,"请求失败", cls);
    }
}
