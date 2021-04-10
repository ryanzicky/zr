package com.web.controller.admin;

import com.github.pagehelper.PageInfo;
import com.web.domain.ResponseEntity;
import com.web.domain.request.MenuRequest;
import com.web.domain.response.MenuResponse;
import com.web.enums.ResponseEnum;
import com.web.generator.dao.TMenu;
import com.web.service.mysql.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/23 15:27
 */
@RestController
@Slf4j
@Api(value = "菜单服务")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取菜单列表")
    @PostMapping("/menuList")
    public ResponseEntity<List<MenuResponse>> menuList(@RequestBody MenuRequest request) {
        return menuService.getList(request);
    }

    @ApiOperation(value = "添加菜单")
    @PostMapping("/addMenu")
    public ResponseEntity<Long> addMenu(@RequestBody MenuRequest request) {
        ResponseEntity<Long> resp = ResponseEntity.success(ResponseEntity.class);
        Long menuId = menuService.addMenu(request);
        resp.setData(menuId);
        resp.setMsg(ResponseEnum.SUCCESS.getName());
        return resp;
    }

    @ApiOperation(value = "删除菜单")
    @PostMapping("/delMenu")
    public ResponseEntity<Integer> delMenu(@RequestBody MenuRequest request) {
        ResponseEntity<Integer> resp = ResponseEntity.success(ResponseEntity.class);
        Integer result = menuService.delMenu(request);
        resp.setData(result);
        resp.setMsg(ResponseEnum.SUCCESS.getName());
        return resp;
    }
}
