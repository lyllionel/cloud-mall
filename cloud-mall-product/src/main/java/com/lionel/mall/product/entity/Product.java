package com.lionel.mall.product.entity;

import com.lionel.mall.common.base.BaseEntity;
import lombok.Data;

@Data
public class Product extends BaseEntity {

    private String name;

    private String price;

}
