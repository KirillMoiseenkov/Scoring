package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GOODS")
public class Goods {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "GOODS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GOODS_SEQ", sequenceName = "GOODS_SEQ", allocationSize = 1)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goods",fetch = FetchType.LAZY)
    private Set<OrderGoods> orderGoods = new HashSet<>();

    @Column(name = "goods_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Set<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", orderGoods=" + orderGoods +
                ", name='" + name + '\'' +
                '}';
    }
}
