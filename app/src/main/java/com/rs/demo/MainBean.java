package com.rs.demo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Rs on 2018/6/26.
 */

public class MainBean  implements MultiItemEntity{
    private int position;
    private String name;
    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainBean(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
