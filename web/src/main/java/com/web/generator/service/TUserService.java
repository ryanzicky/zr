package com.web.generator.service;

import com.github.pagehelper.PageInfo;
import com.web.domain.request.UserRequest;
import com.web.generator.dao.TUser;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/22 10:25
 */
public interface TUserService {

    /**
     * 获取列表
     *
     * @param request
     * @return
     */
    PageInfo<TUser> getList(UserRequest request);

    /**
     * 添加用户
     *
     * @param tUser
     * @return
     */
    Long addUser(TUser tUser);

    /**
     * 删除用户
     *
     * @param tUser
     * @return
     */
    Integer delUser(TUser tUser);
}
