package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.domain.request.PermissionRequest;
import com.web.generator.dao.TPermission;
import com.web.generator.mapper.TPermissionMapper;
import com.web.generator.service.TPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhourui
 * @since 2020-12-23
 */
@Service
public class TPermissionServiceImpl extends ServiceImpl<TPermissionMapper, TPermission> implements TPermissionService {

    @Override
    public PageInfo<TPermission> getList(PermissionRequest request) {
        EntityWrapper<TPermission> wrapper = new EntityWrapper<>();
        wrapper.eq("is_remove", 0);
        if (null != request.getId()) {
            wrapper.eq("id", request.getId());
        }
        if (StringUtils.isNotBlank(request.getPermissionName())) {
            wrapper.like("permission_name", request.getPermissionName());
        }
        if (StringUtils.isNotBlank(request.getPermissionDesc())) {
            wrapper.like("permission_desc", request.getPermissionDesc());
        }
        wrapper.orderBy("update_date", false);

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<TPermission> tPermissions = this.baseMapper.selectList(wrapper);
        return PageInfo.of(tPermissions);
    }

    @Override
    public Long addPermission(PermissionRequest request) {
        TPermission tPermission = new TPermission();
        BeanUtils.copyProperties(request, tPermission);

        this.baseMapper.insert(tPermission);
        return tPermission.getId();
    }

    @Override
    public Integer delPermission(PermissionRequest request) {
        TPermission tPermission = new TPermission();
        tPermission.setId(request.getId());
        tPermission.setIsRemove(1);
        return this.baseMapper.updateById(tPermission);
    }
}
