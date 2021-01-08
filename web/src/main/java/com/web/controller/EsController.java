package com.web.controller;

import com.web.service.es.EsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhourui
 * @Date 2020/12/30 10:47
 */
@RestController
@Slf4j
@Api(value = "Es服务")
@RequestMapping("/es")
public class EsController {

    @Autowired
    private EsService esService;

    @GetMapping("/getMvList")
    public void getMvList() {
        esService.getMovieList();
    }
}
