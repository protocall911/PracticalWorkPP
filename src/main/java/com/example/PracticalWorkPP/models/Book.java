package com.example.PracticalWorkPP.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;

    @NotEmpty(message = "Заполните поле Название")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Заполните поле Жанр")
    @Size(min = 3, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 3 до 50")
    @Column(name = "genre")
    private String genre;

    @NotEmpty(message = "Заполните поле Издательство")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 50")
    @Column(name = "publishinghouse")
    private String publishinghouse;

    @NotEmpty(message = "Заполните поле Место издания")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 50")
    @Column(name = "placeofpublication")
    private String placeofpublication;

    @NotEmpty(message = "Заполните поле Автор")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 100")
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
