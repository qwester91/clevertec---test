package by.harashchenia.dao.entities;

public class Card {
    private long id;
    private double discount;

    public Card(long id, double discount) {
        this.id = id;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public double getDiscount() {
        return discount;
    }
}
