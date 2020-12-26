package com.web.generator.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.domain.request.MenuRequest;
import com.web.generator.dao.TMenu;
import com.web.generator.mapper.TMenuMapper;
import com.web.generator.service.TMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements TMenuService {

    @Override
    public PageInfo<TMenu> getList(MenuRequest request) {
        EntityWrapper<TMenu> wrapper = new EntityWrapper<>();

        wrapper.eq("is_remove", 0);
        if (StringUtils.isNotBlank(request.getMenuName())) {
            wrapper.like("menu_name", request.getMenuName());
        }
        if (StringUtils.isNotBlank(request.getMenuDesc())) {
            wrapper.like("menu_desc", request.getMenuDesc());
        }
        if (StringUtils.isNotBlank(request.getMenuUri())) {
            wrapper.like("menu_uir", request.getMenuUri());
        }
        if (StringUtils.isNotBlank(request.getParentUid())) {
            wrapper.eq("parent_uid", request.getParentUid());
        }
        wrapper.orderBy("update_date", false);
        wrapper.orderBy("sort");

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<TMenu> tMenus = this.baseMapper.selectList(wrapper);

        return PageInfo.of(tMenus);
    }

    @Override
    public Long addMenu(TMenu tMenu) {
        this.baseMapper.insert(tMenu);
        return tMenu.getId();
    }

    @Override
    public Integer delMenu(TMenu tMenu) {
        return this.baseMapper.updateById(tMenu);
    }

    @Override
    public List<TMenu> getMaxSort(String parentUid) {
        EntityWrapper<TMenu> wrapper = new EntityWrapper<>();
        wrapper.eq("is_remove", 0);
        if (StringUtils.isBlank(parentUid)) {
            wrapper.isNull("parent_uid");
        } else {
            wrapper.eq("parent_uid", parentUid);
        }
        wrapper.orderBy("update_date", false);
        return this.baseMapper.selectList(wrapper);
    }
}
