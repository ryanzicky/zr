package com.web.controller.admin;

import com.web.domain.ResponseEntity;
import com.web.domain.request.PermissionRequest;
import com.web.domain.response.UserResponse;
import com.web.generator.dao.TPermission;
import com.web.service.PermissionService;
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
@Api(value = "权限服务")
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取菜单列表")
    @PostMapping("/permissionList")
    public ResponseEntity<List<TPermission>> permissionList(@RequestBody PermissionRequest request) {
        return permissionService.getList(request);
    }

    @ApiOperation(value = "添加权限")
    @PostMapping("/addPermission")
    public ResponseEntity<Long> addPermission(@RequestBody PermissionRequest request) {
        return permissionService.addPermission(request);
    }

    @ApiOperation(value = "删除权限")
    @PostMapping("/delPermission")
    public ResponseEntity<Integer> delPermission(@RequestBody PermissionRequest request) {
        return permissionService.delPermission(request);
    }
}
