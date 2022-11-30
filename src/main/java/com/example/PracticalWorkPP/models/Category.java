package com.example.PracticalWorkPP.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String nameCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Collection<Stationery> goods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nameCategory;
    }

    public void setName(String name) {
        this.nameCategory = name;
    }

    public Collection<Stationery> getGoods() {
        return goods;
    }

    public void setGoods(Collection<Stationery> goods) {
        this.goods = goods;
    }
}
