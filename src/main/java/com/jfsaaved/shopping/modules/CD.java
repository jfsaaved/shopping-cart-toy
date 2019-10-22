package com.jfsaaved.shopping.modules;

import com.jfsaaved.shopping.modules.enums.CDGenre;
import com.jfsaaved.shopping.modules.enums.ItemType;
import com.jfsaaved.shopping.modules.enums.WarrantyType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CD extends Item{

    private String asin;
    private CDGenre cdGenre;
    private String artist;
    private String label;
    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private Date datePublished;

    public CD(){

    }

    public CD(String name, String asin){
        super(name, ItemType.CD);
        this.asin = asin;
        this.cdGenre = CDGenre.NOT_SPECIFIED;
        this.artist = "Anonymous";
        this.label = "Not Available";
        this.datePublished = new Date();
    }

    public CD withCDGenre(CDGenre cdGenre){
        this.cdGenre = cdGenre;
        return this;
    }

    public CD withArtist(String artist){
        this.artist = artist;
        return this;
    }

    public CD withLabel(String label){
        this.label = label;
        return this;
    }

    public CD withDatePublished(Date datePublished){
        this.datePublished = datePublished;
        return this;
    }

    @Override
    public CD withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public CD withWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    @Override
    public CD withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public CD withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public CD withImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public CDGenre getCdGenre() {
        return cdGenre;
    }

    public void setCdGenre(CDGenre cdGenre) {
        this.cdGenre = cdGenre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

}
