package com.web.generator.service;

import com.github.pagehelper.PageInfo;
import com.web.domain.request.MenuRequest;
import com.web.generator.dao.TMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhourui
 * @since 2020-12-23
 */
public interface TMenuService extends IService<TMenu> {

    /**
     * 获取菜单列表
     *
     * @param request
     * @return
     */
    PageInfo<TMenu> getList(MenuRequest request);

    /**
     * 添加菜单
     *
     * @param tMenu
     * @return
     */
    Long addMenu(TMenu tMenu);

    /**
     * 删除菜单
     *
     * @param tMenu
     * @return
     */
    Integer delMenu(TMenu tMenu);

    /**
     * 获取最大序号
     *
     * @param parentUid
     * @return
     */
    List<TMenu> getMaxSort(String parentUid);
}
