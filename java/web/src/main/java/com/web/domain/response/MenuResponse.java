package com.web.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author zhourui
 * @Date 2020/12/24 16:26
 */
@Data
@Builder
@ApiModel(value = "菜单返回")
public class MenuResponse {

    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "父级uid")
    private String parentUid;
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    @ApiModelProperty(value = "菜单描述")
    private String menuDesc;
    @ApiModelProperty(value = "菜单路径")
    private String menuUri;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "子菜单")
    private List<MenuResponse> childList;
}
