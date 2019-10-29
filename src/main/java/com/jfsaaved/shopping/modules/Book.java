package com.jfsaaved.shopping.modules;

import com.jfsaaved.shopping.modules.enums.BookAvailability;
import com.jfsaaved.shopping.modules.enums.BookGenre;
import com.jfsaaved.shopping.modules.enums.ItemType;
import com.jfsaaved.shopping.modules.enums.WarrantyType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book extends Item{

    private BookGenre genre;
    private String isbn;
    private String author;
    private ArrayList<String> authors;
    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private Date datePublished;
    private int pages;
    private BookAvailability bookAvailability;

    public Book() {

    }

    public Book(String name, String isbn){
        super(name, ItemType.BOOK);
        this.isbn = isbn;
        this.genre = BookGenre.GENERAL;
        this.author = "Anonymous";
        this.datePublished = new Date();
        this.pages = 0;
        this.bookAvailability = BookAvailability.PAPERBACK;
    }

    public Book withAuthors(ArrayList<String> authors){
        this.authors = authors;
        return this;
    }

    public Book withGenre(BookGenre genre){
        this.genre = genre;
        return this;
    }

    public Book withAuthor(String author){
        this.author = author;
        return this;
    }

    public Book withDatePublished(Date datePublished){
        this.datePublished = datePublished;
        return this;
    }

    public Book withPages(int pages){
        this.pages = pages;
        return this;
    }

    public Book withBookAvailability(BookAvailability bookAvailability){
        this.bookAvailability = bookAvailability;
        return this;
    }

    @Override
    public Book withWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    @Override
    public Book withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public Book withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public Book withDescription(String description){
        this.description = description;
        return this;
    }

    @Override
    public Book withImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
        return this;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookAvailability getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(BookAvailability bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}
