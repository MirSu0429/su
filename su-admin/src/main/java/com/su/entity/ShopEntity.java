package com.su.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: supengfei
 * @Date: 2019/5/20 22:20
 * @Description:
 */
@TableName("lb_shop")
@Data
public class ShopEntity extends Model<ShopEntity> {
    @TableId(value = "id")
    private Integer id;
    @TableId(value = "shop_name")
    private String shopName;
    @TableId(value = "shop_tel")
    private String shopTel;
    @TableId(value = "shop_address")
    private String shopAddress;
    @TableId(value = "shop_manager")
    private String shopManager;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
