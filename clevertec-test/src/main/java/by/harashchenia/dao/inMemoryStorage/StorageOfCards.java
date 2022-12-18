package by.harashchenia.dao.inMemoryStorage;

import by.harashchenia.dao.entities.Card;

import java.util.ArrayList;
import java.util.List;

public class StorageOfCards {
    private List<Card> storageOfCards;

    public StorageOfCards() {
        storageOfCards = new ArrayList<>();
        Card card = new Card(1111, 10.0);
        storageOfCards.add(card);
        card = new Card(2222, 8.5);
        storageOfCards.add(card);
    }

    public List<Card> getStorageOfCards() {
        return storageOfCards;
    }
}
