package com.web.service.mysql;

import com.github.pagehelper.PageInfo;
import com.web.domain.ResponseEntity;
import com.web.domain.request.MenuRequest;
import com.web.domain.response.MenuResponse;
import com.web.enums.TypeEnum;
import com.web.generator.dao.TMenu;
import com.web.generator.service.TMenuService;
import com.web.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhourui
 * @Date 2020/12/23 15:56
 */
@Service
public class MenuService {

    @Autowired
    private TMenuService tMenuService;

    public List<MenuResponse> recursionList(List<TMenu> resultList, List<MenuResponse> list) {
        resultList.parallelStream().map(x -> x.setParentUid(StringUtils.isBlank(x.getParentUid()) ? "" : x.getParentUid())).collect(Collectors.groupingBy(TMenu::getParentUid));

        list.forEach(resp -> {

        });
        return list;
    }

    public ResponseEntity<List<MenuResponse>> getList(MenuRequest request) {

        ResponseEntity<List<MenuResponse>> resp = ResponseEntity.success(ResponseEntity.class);
        PageInfo<TMenu> result = tMenuService.getList(request);

        List<MenuResponse> list = Lists.newArrayList();
        list = recursionList(result.getList(), list);

        resp.setData(list);
        resp.setPages(result.getPages());
        resp.setTotal(result.getTotal());
        return resp;
    }

    public Long addMenu(MenuRequest request) {
        TMenu tMenu = convertRequest(request);
        tMenu.setSort(getMaxSort(request.getParentUid()) + 1);
        tMenu.setUid(RandomUtil.UUIDWithSalt(TypeEnum.MENU.getName(), String.valueOf(System.currentTimeMillis())));
        return tMenuService.addMenu(tMenu);
    }

    public TMenu convertRequest(MenuRequest request) {
        TMenu tMenu = new TMenu();
        BeanUtils.copyProperties(request, tMenu);

        return tMenu;
    }

    public Integer delMenu(MenuRequest request) {
        TMenu tMenu = convertRequest(request);
        tMenu.setIsRemove(1);
        return tMenuService.delMenu(tMenu);
    }

    /**
     * 获取最大sort
     *
     * @param parentUid
     * @return
     */
    public Integer getMaxSort(String parentUid) {
        List<TMenu> maxSort = tMenuService.getMaxSort(parentUid);
        if (CollectionUtils.isEmpty(maxSort)) {
            return 0;
        }
        return maxSort.get(0).getSort();
    }
}
