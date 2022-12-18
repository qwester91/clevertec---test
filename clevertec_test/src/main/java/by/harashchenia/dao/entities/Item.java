package by.harashchenia.dao.entities;

import java.math.BigDecimal;

public class Item {
    private Long id;
    private String name;
    private boolean inSale;
    private BigDecimal cost;

    public Item(long id, String name, boolean inSale, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.inSale = inSale;
        this.cost = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isInSale() {
        return inSale;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inSale=" + inSale +
                ", cost=" + cost +
                '}';
    }
}
