package com.njrhzn.ew.Model;

import java.math.BigDecimal;

public class Product {
    /**
     * 商品名称
     * */
    private String ProductName;
    /**
     * 0 小杯；1中杯；2大杯
     * */
    private int style;
    /**
     * 冷还是热
     * */
    private boolean isHot;
    /**
     * 价格
     * */
    private BigDecimal price;

    public Product(String productName, int style, boolean isHot, BigDecimal price) {
        ProductName = productName;
        this.style = style;
        this.isHot = isHot;
        this.price = price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
