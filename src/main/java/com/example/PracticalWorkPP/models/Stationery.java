package com.example.PracticalWorkPP.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stationery")
public class Stationery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Category category;

    public Stationery() {

    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Stationery(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
