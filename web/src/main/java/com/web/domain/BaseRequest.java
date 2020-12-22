package com.web.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zhourui
 * @Date 2020/5/9 10:15
 */
@Data
@ApiModel(description = "基本请求类")
public class BaseRequest {

    @ApiModelProperty(value = "页码")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;
}
