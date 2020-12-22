package com.web.config;

import com.web.domain.ResponseEntity;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhourui
 * @Date 2020/12/22 13:54
 */
@ControllerAdvice
public class ActionAdvice {

    @InitBinder
    public void handleException(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity handleException(Exception ex) {
        return new ResponseEntity(500, ex.toString());
    }
}
