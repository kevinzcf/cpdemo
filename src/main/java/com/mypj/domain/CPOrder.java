package com.mypj.domain;

import com.mypj.enums.CPOrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author kevinzcf
 */
@Entity
public class CPOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private String consumerId;
    private String supplierId;
    private String itemName;
    private String itemImage;
    private String itemDescriptions;
    // e.g. 商铺名 搜索字段
    private String itemDescriptionsHide;
    private String amaOrderId;
    private String reviewUrl;
    private String picture;
    private CPOrderStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDescriptions() {
        return itemDescriptions;
    }

    public void setItemDescriptions(String itemDescriptions) {
        this.itemDescriptions = itemDescriptions;
    }

    public String getItemDescriptionsHide() {
        return itemDescriptionsHide;
    }

    public void setItemDescriptionsHide(String itemDescriptionsHide) {
        this.itemDescriptionsHide = itemDescriptionsHide;
    }

    public String getAmaOrderId() {
        return amaOrderId;
    }

    public void setAmaOrderId(String amaOrderId) {
        this.amaOrderId = amaOrderId;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CPOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CPOrderStatus status) {
        this.status = status;
    }
}
