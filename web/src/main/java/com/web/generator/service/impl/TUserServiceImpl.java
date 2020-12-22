package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.web.domain.request.UserRequest;
import com.web.generator.dao.TUser;
import com.web.generator.mapper.TUserMapper;
import com.web.generator.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/22 10:25
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Override
    public List<TUser> getList(UserRequest request) {
        EntityWrapper<TUser> wrapper = new EntityWrapper<>();
        wrapper.eq("is_remove", 0);
        if (null != request.getId()) {
            wrapper.eq("id", request.getId());
        }
        if (StringUtils.isNoneBlank(request.getName())) {
            wrapper.like("name", request.getName());
        }
        wrapper.orderBy("id", false);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public Long addUser(TUser tUser) {
        TUser user = getUser(tUser);
        if (null != user) {
            return user.getId();
        }
        this.baseMapper.insert(tUser);
        return tUser.getId();
    }

    @Override
    public Integer delUser(TUser tUser) {
        tUser.setIsRemove(1);
        return this.baseMapper.updateById(tUser);
    }

    private TUser getUser(TUser tUser) {
        return this.baseMapper.selectOne(tUser);
    }
}
