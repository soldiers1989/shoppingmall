package com.zhkj.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Orderfromshop0Entity {
    private Integer id;
    private int feight;
    private Double commodityPrice;
    private Integer commodityNumber;
    private Integer logisticsTypeId;
    private Integer commodityId;
    private String orderFromId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFeight() {
        return feight;
    }

    public void setFeight(int feight) {
        this.feight = feight;
    }

    public Double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public Integer getLogisticsTypeId() {
        return logisticsTypeId;
    }

    public void setLogisticsTypeId(Integer logisticsTypeId) {
        this.logisticsTypeId = logisticsTypeId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getOrderFromId() {
        return orderFromId;
    }

    public void setOrderFromId(String orderFromId) {
        this.orderFromId = orderFromId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderfromshop0Entity that = (Orderfromshop0Entity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(feight, that.feight) &&
                Objects.equals(commodityPrice, that.commodityPrice) &&
                Objects.equals(commodityNumber, that.commodityNumber) &&
                Objects.equals(logisticsTypeId, that.logisticsTypeId) &&
                Objects.equals(commodityId, that.commodityId) &&
                Objects.equals(orderFromId, that.orderFromId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, feight, commodityPrice, commodityNumber, logisticsTypeId, commodityId, orderFromId);
    }
}
