package com.web.controller.user;

import com.alibaba.fastjson.JSON;
import com.web.domain.ResponseEntity;
import com.web.domain.request.UserRequest;
import com.web.domain.response.UserResponse;
import com.web.service.mysql.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/22 9:44
 */
@RestController
@Slf4j
@Api(value = "用户服务")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表")
    @PostMapping("/userList")
    public ResponseEntity<List<UserResponse>> userList(@RequestBody UserRequest request) {
        try {
            log.info("request = {}", JSON.toJSONString(request));
            ResponseEntity<List<UserResponse>> resp = ResponseEntity.success(ResponseEntity.class);
            resp.setData(userService.getUserList(request));
            resp.setMsg("获取用户列表成功!");
            return resp;
        } catch (Exception e) {
            log.error("获取用户列表失败!,{}, {}", JSON.toJSONString(request), e);
            return new ResponseEntity(500, "获取用户列表失败!");
        }
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/addUser")
    public ResponseEntity<Long> addUser(@RequestBody UserRequest request) {
        try {
            log.info("request = {}", JSON.toJSONString(request));
            ResponseEntity<Long> resp = ResponseEntity.success(ResponseEntity.class);
            resp.setData(userService.addUser(request));
            resp.setMsg("添加用户成功!");
            return resp;
        } catch (Exception e) {
            log.error("添加用户失败!,{}, {}", JSON.toJSONString(request), e);
            return new ResponseEntity(500, "添加用户失败!");
        }
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/delUser")
    public ResponseEntity<Integer> delUser(@RequestBody UserRequest request) {
        try {
            log.info("request = {}", JSON.toJSONString(request));
            ResponseEntity<Integer> resp = ResponseEntity.success(ResponseEntity.class);
            resp.setData(userService.delUser(request));
            resp.setMsg("删除用户成功!");
            return resp;
        } catch (Exception e) {
            log.error("删除用户失败!,{}, {}", JSON.toJSONString(request), e);
            return new ResponseEntity(500, "删除用户失败!");
        }
    }

    @ApiOperation(value = "测试全局Advice")
    @PostMapping("/testAdvice")
    public ResponseEntity<String> testAdvice(@RequestBody UserRequest request) throws Exception {
        if (request.getName().equals("success")) {
            ResponseEntity<String> resp = ResponseEntity.success(ResponseEntity.class);
            resp.setData(request.getName());
            return resp;
        } else {
            throw new Exception(request.getName());
        }
    }
}
