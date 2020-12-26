package com.web.generator.service;

import com.github.pagehelper.PageInfo;
import com.web.domain.request.PermissionRequest;
import com.web.generator.dao.TPermission;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhourui
 * @since 2020-12-23
 */
public interface TPermissionService extends IService<TPermission> {

    PageInfo<TPermission> getList(PermissionRequest request);

    Long addPermission(PermissionRequest request);

    Integer delPermission(PermissionRequest request);
}
