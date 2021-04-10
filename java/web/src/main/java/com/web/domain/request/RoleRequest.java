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
@ApiModel(value = "角色请求")
public class RoleRequest extends BaseRequest {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
    @ApiModelProperty(value = "创建者")
    private String createName;
    @ApiModelProperty(value = "修改者")
    private String updateName;
}
