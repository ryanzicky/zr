package com.web.generator.service;

import com.web.domain.request.UserRequest;
import com.web.generator.dao.TUser;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/22 10:25
 */
public interface TUserService {

    List<TUser> getList(UserRequest request);

    Long addUser(TUser tUser);

    Integer delUser(TUser tUser);
}
