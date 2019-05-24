package com.su.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: supengfei
 * @Date: 2019/5/20 22:21
 * @Description:
 */
@TableName("lb_register")
@Data
public class RegisterInfoEntity extends Model<RegisterInfoEntity> {
    @TableId(value = "id")
    private int id;
    @TableField(value = "shop_id")
    private Integer shopId;
    @TableField(value = "name")
    private String name;
    @TableField(value = "car_type")
    private String carType;
    @TableField(value = "tel")
    private String tel;
    @TableField(value = "car_number")
    private String carNumber;
    @TableField(value = "is_come")
    private int isCome;
    @TableField(value = "status")
    private int status;
    @TableField(value = "description")
    private String description;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "update_time")
    private Date updateTime;
    @TableField(value = "come_time")
    private Date comeTime;

    @Override

    protected Serializable pkVal() {
        return null;
    }
}
