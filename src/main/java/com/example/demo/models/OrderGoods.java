package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_GOODS")
public class OrderGoods {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDERS_GOODS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ORDERS_GOODS_SEQ", sequenceName = "ORDERS_GOODS_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private Order orders;

    @Column(name = "GOODS_COUNT")
    private Long goodsCount;

    @Column(name = "TOTAL_AMOUNT")
    private Long totalAmount;

    @Column(name = "GOODS_COST")
    private Long goodsCost;


    public long getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Long goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(Long goodsCost) {
        this.goodsCost = goodsCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", goods=" + goods.getName() +
                ", orders=" + orders.getId() +
                ", goodsCount=" + goodsCount +
                ", totalAmount=" + totalAmount +
                ", goodsCost=" + goodsCost +
                '}';
    }
}
