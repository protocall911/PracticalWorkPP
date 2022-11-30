package com.example.PracticalWorkPP.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;

    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 50")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 50")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 50, message = "Количество символов должно быть в\n" +
            "диапозоне от 1 до 50")
    @Column(name = "middlename")
    private String middlename;

//    @Past
    @NotNull(message = "Заполните поле")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @NotNull(message = "Заполните поле")
    @Min(value = 0, message = "Значение в поле не может быть меньше нуля")
    @Column(name = "totalworks")
    private Integer totalworks;

    public Author(String firstname, String lastname, String middlename, Date birthday, Integer totalworks) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.totalworks = totalworks;
    }

    public Author() {

    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getTotalworks() {
        return totalworks;
    }

    public void setTotalworks(Integer totalworks) {
        this.totalworks = totalworks;
    }

}
