package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.domain.ResponseEntity;
import com.web.domain.request.PermissionRequest;
import com.web.generator.dao.TPermission;
import com.web.generator.service.TPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/24 16:00
 */
@Service
public class PermissionService {

    @Autowired
    private TPermissionService tPermissionService;

    public ResponseEntity<List<TPermission>> getList(PermissionRequest request) {
        ResponseEntity<List<TPermission>> resp = ResponseEntity.success(ResponseEntity.class);
        PageInfo<TPermission> pageInfo = tPermissionService.getList(request);
        resp.setData(pageInfo.getList());
        resp.setPages(pageInfo.getPages());
        resp.setTotal(pageInfo.getTotal());

        return resp;
    }

    public ResponseEntity<Long> addPermission(PermissionRequest request) {
        ResponseEntity<Long> resp = ResponseEntity.success(ResponseEntity.class);
        Long result = tPermissionService.addPermission(request);
        resp.setData(result);
        return resp;
    }

    public ResponseEntity<Integer> delPermission(PermissionRequest request) {
        ResponseEntity<Integer> resp = ResponseEntity.success(ResponseEntity.class);
        Integer result = tPermissionService.delPermission(request);
        resp.setData(result);
        return resp;
    }
}
