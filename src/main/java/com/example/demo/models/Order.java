package com.example.demo.models;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDERS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ORDERS_SEQ", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partner_id")
    private Partners partners;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_id")
    private POS pos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Partners getPartners() {
        return partners;
    }

    public void setPartners(Partners partners) {
        this.partners = partners;
    }

    public POS getPos() {
        return pos;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }
}
