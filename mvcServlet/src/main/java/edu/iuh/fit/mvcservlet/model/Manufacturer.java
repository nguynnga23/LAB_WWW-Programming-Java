package edu.iuh.fit.mvcservlet.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    private int manid;

    private String name;

    @OneToMany(mappedBy = "manid")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(int manid, String name) {
        this.manid = manid;
        this.name = name;
    }

    public int getManid() {
        return manid;
    }

    public void setManid(int manid) {
        this.manid = manid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
