package by.harashchenia.dao.entities;

public class StringInReceipt {
    private Long qty;
    private Item item;


    public StringInReceipt(Long qty, Item item) {
        this.qty = qty;
        this.item = item;
    }

    public Long getQty() {
        return qty;
    }

    public Item getItem() {
        return item;
    }
}
