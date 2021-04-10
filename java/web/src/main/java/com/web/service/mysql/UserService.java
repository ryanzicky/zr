package com.web.service.mysql;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.web.domain.ResponseEntity;
import com.web.domain.request.UserRequest;
import com.web.domain.response.UserResponse;
import com.web.enums.TypeEnum;
import com.web.generator.dao.TUser;
import com.web.generator.service.TUserService;
import com.web.utils.RandomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/22 10:31
 */
@Service
public class UserService {

    @Autowired
    private TUserService tUserService;

    public ResponseEntity<List<UserResponse>> getUserList(UserRequest request) {
        ResponseEntity<List<UserResponse>> resp = ResponseEntity.success(ResponseEntity.class);

        List<UserResponse> responseList = Lists.newArrayList();
        PageInfo<TUser> pageInfo = tUserService.getList(request);
        pageInfo.getList().forEach(user -> {
            UserResponse userResponse = UserResponse.builder().build();
            BeanUtils.copyProperties(user, userResponse);

            responseList.add(userResponse);
        });

        resp.setData(responseList);
        resp.setMsg("获取用户列表成功!");
        resp.setTotal(pageInfo.getTotal());
        resp.setPages(pageInfo.getPages());

        return resp;
    }

    public Long addUser(UserRequest request) {
        TUser tUser = new TUser();
        BeanUtils.copyProperties(request, tUser);
        tUser.setIsRemove(0);
        tUser.setPassword(RandomUtil.UUIDWithSalt(tUser.getName(), tUser.getPassword()));
        tUser.setUid(RandomUtil.UUIDWithSalt(TypeEnum.USER.getName(), String.valueOf(System.currentTimeMillis())));
        return tUserService.addUser(tUser);
    }

    public Integer delUser(UserRequest request) {
        TUser tUser = new TUser();
        tUser.setId(request.getId());
        return tUserService.delUser(tUser);
    }

}
