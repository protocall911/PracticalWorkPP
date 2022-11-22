package com.example.PracticalWorkPP.models;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publishinghouse")
    private String publishinghouse;

    @Column(name = "placeofpublication")
    private String placeofpublication;

    @Column(name = "author")
    private String author;

    public Book(String title, String genre, String publishinghouse, String placeofpublication, String author) {
        this.title = title;
        this.genre = genre;
        this.publishinghouse = publishinghouse;
        this.placeofpublication = placeofpublication;
        this.author = author;
    }

    public Book() {

    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishinghouse() {
        return publishinghouse;
    }

    public void setPublishinghouse(String publishinghouse) {
        this.publishinghouse = publishinghouse;
    }

    public String getPlaceofpublication() {
        return placeofpublication;
    }

    public void setPlaceofpublication(String placeofpublication) {
        this.placeofpublication = placeofpublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
