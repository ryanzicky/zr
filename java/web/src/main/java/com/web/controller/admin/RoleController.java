package com.web.controller.admin;

import com.web.domain.ResponseEntity;
import com.web.domain.request.RoleRequest;
import com.web.domain.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api(value = "角色服务")
@RequestMapping("/role")
public class RoleController {

    @ApiOperation(value = "获取角色列表")
    @PostMapping("/roleList")
    public ResponseEntity<List<UserResponse>> roleList(@RequestBody RoleRequest request) {
        return null;
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/addRole")
    public ResponseEntity<List<UserResponse>> addRole(@RequestBody RoleRequest request) {
        return null;
    }

    @ApiOperation(value = "删除角色")
    @PostMapping("/delRole")
    public ResponseEntity<List<UserResponse>> delRole(@RequestBody RoleRequest request) {
        return null;
    }
}
