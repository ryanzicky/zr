package com.web.service.mysql;

import com.google.common.collect.Lists;
import com.web.domain.request.UserRequest;
import com.web.domain.response.UserResponse;
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

    public List<UserResponse> getUserList(UserRequest request) {
        List<UserResponse> responseList = Lists.newArrayList();
        List<TUser> list = tUserService.getList(request);
        list.forEach(user -> {
            UserResponse resp = UserResponse.builder().build();
            BeanUtils.copyProperties(user, resp);

            responseList.add(resp);
        });
        return responseList;
    }

    public Long addUser(UserRequest request) {
        TUser tUser = new TUser();
        BeanUtils.copyProperties(request, tUser);
        tUser.setIsRemove(0);
        tUser.setPassword(RandomUtil.UUID(tUser.getName(), tUser.getPassword()));
        return tUserService.addUser(tUser);
    }

    public Integer delUser(UserRequest request) {
        TUser tUser = new TUser();
        tUser.setId(request.getId());
        return tUserService.delUser(tUser);
    }

}
