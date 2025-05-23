package com.vicwang17.yueqiu.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 标签
 * @TableName tag
 */
@TableName(value ="tag")
@Data
public class Tag implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签名称
     */
    @TableField(value = "tagName")
    private String tagName;

    /**
     * 用户id
     */
    @TableField(value = "userId")
    private String userId;

    /**
     * 父标签名称
     */
    @TableField(value = "parentId")
    private Long parentId;

    /**
     * 0 - 不是， 1 - 父标签
     */
    @TableField(value = "isParent")
    private Integer isParent;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "updateTime")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(value = "isDelete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}