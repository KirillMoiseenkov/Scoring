package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "POS")
public class POS {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "POS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "POS_SEQ", sequenceName = "POS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "REGION")
    private String region;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CODE")
    private Long code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pos", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
