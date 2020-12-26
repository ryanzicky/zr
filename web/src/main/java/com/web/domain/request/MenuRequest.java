package com.web.domain.request;

import com.web.domain.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zhourui
 * @Date 2020/12/22 9:50
 */
@Data
@ApiModel(value = "菜单请求")
public class MenuRequest extends BaseRequest {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    @ApiModelProperty(value = "菜单描述")
    private String menuDesc;
    @ApiModelProperty(value = "创建者")
    private String createName;
    @ApiModelProperty(value = "修改者")
    private String updateName;
    @ApiModelProperty(value = "菜单路径")
    private String menuUri;
    @ApiModelProperty(value = "父级菜单uid")
    private String parentUid;
}
