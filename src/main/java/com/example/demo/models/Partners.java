package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PARTNERS")
public class Partners {


    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "PARTNERS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PARTNERS_SEQ", sequenceName = "PARTNERS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGION")
    private String region;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "CITY")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partners", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
