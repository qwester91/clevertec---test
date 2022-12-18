package by.harashchenia.service;

import by.harashchenia.dao.entities.Card;
import by.harashchenia.dao.entities.Item;
import by.harashchenia.dao.entities.Receipt;
import by.harashchenia.dao.entities.StringInReceipt;
import by.harashchenia.dao.inMemoryStorage.StorageOfCards;
import by.harashchenia.dao.inMemoryStorage.StorageOfItems;
import by.harashchenia.dao.inMemoryStorage.api.IInMemoryStorage;
import by.harashchenia.service.api.IService;
import by.harashchenia.service.converter.FromMapArgsToItems;

import java.util.List;
import java.util.Map;

public class Service implements IService {
     private Map<String,String> commandLineArgs;
     private Card card;
    public Service(Map<String, String> commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }
    @Override
    public Card getCard(){
        Card card = new Card(0,0);
        if(commandLineArgs.containsKey("card")){
            Long id = Long.parseLong(commandLineArgs.get("card"));
            commandLineArgs.remove("card");
            IInMemoryStorage<Card> storageOfCards = new StorageOfCards();
            List<Card> cards = storageOfCards.getStorage();
             for (Card cardInStorage : cards) {
                if(cardInStorage.getId().equals(id)){
                    card = cardInStorage;
                }
            }

        }
        this.card = card;
        return this.card;
    }

    @Override
    public Receipt getReceipt(){
        FromMapArgsToItems fromMapArgsToItems = new FromMapArgsToItems(commandLineArgs);
        Map<Long, Long> idAndQty = fromMapArgsToItems.getIdAndQty();
        IInMemoryStorage<Item> storageOfItems = new StorageOfItems();
        List<Item> localStorageOfItems = storageOfItems.getStorage();
        Receipt receipt = new Receipt(card);
        for (Item localStorageOfItem : localStorageOfItems) {
            for (Long aLong : idAndQty.keySet()) {
                if(localStorageOfItem.getId().equals(aLong)){
                    receipt.addItemInReceipt(new StringInReceipt(idAndQty.get(aLong), localStorageOfItem));
                }
            }
        }
        return receipt;
    }
}
