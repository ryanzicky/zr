package com.web.generator.dao;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhourui
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_role")
public class TUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户uid
     */
    @TableField("user_uid")
    private String userUid;
    /**
     * 角色uid
     */
    @TableField("role_uid")
    private String roleUid;
    /**
     * 是否删除
     */
    @TableField("is_remove")
    private Integer isRemove;
    /**
     * 创建者
     */
    @TableField("create_name")
    private String createName;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 修改者
     */
    @TableField("update_name")
    private String updateName;
    /**
     * 修改时间
     */
    @TableField("update_date")
    private Date updateDate;


}
