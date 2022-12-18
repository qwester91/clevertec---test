package by.harashchenia.dao.inMemoryStorage;

import by.harashchenia.dao.entities.Item;
import by.harashchenia.dao.inMemoryStorage.api.IInMemoryStorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StorageOfItems implements IInMemoryStorage<Item> {

    private List<Item> storageOfItems;

    public StorageOfItems() {
        storageOfItems = new ArrayList<>();
        Item item = new Item(1,"item 1", true, BigDecimal.valueOf(1.95));
        storageOfItems.add(item);
        item = new Item(2,"item 2", false, BigDecimal.valueOf(1.25));
        storageOfItems.add(item);
        item = new Item(3,"item 3", true, BigDecimal.valueOf(1.35));
        storageOfItems.add(item);
        item = new Item(4,"item 4", false, BigDecimal.valueOf(2.25));
        storageOfItems.add(item);
        item = new Item(5,"item 5", false, BigDecimal.valueOf(1.12));
        storageOfItems.add(item);

    }

    public List<Item> getStorage() {
        return storageOfItems;
    }
}
