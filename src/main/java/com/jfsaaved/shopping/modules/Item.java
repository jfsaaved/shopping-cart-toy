package com.jfsaaved.shopping.modules;

import com.jfsaaved.shopping.modules.enums.ItemType;
import com.jfsaaved.shopping.modules.enums.WarrantyType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance
public abstract class Item   {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected String description;
    protected BigDecimal price;
    protected BigDecimal discount;
    protected int discountThreshold;
    protected boolean discountEligible;
    protected WarrantyType warrantyType;
    protected ItemType itemType;
    protected String imgUrl;

    public Item() {

    }

    public Item(String name, ItemType itemType) {
        this.name = name;
        this.description = "No description.";
        this.itemType = itemType;
        this.warrantyType = WarrantyType.NONE;
        this.discount = BigDecimal.valueOf(0);
        this.price = BigDecimal.valueOf(0);
        this.imgUrl = "https://image.flaticon.com/icons/png/512/36/36601.png";
        this.discountThreshold = 5;
        this.discountEligible = false;
    }

    public abstract Item withDescription(String description);
    public abstract Item withWarrantyType(WarrantyType warrantyType);
    public abstract Item withDiscount(BigDecimal discount);
    public abstract Item withPrice(BigDecimal price);
    public abstract Item withImgUrl(String imgUrl);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDiscountThreshold() {
        return discountThreshold;
    }

    public void setDiscountThreshold(int discountThreshold) {
        this.discountThreshold = discountThreshold;
    }

    public boolean isDiscountEligible() {
        return discountEligible;
    }

    public void setDiscountEligible(boolean discountEligible) {
        this.discountEligible = discountEligible;
    }

}
