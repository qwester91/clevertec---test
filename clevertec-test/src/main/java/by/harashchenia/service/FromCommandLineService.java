package by.harashchenia.service;

import by.harashchenia.dao.entities.Card;
import by.harashchenia.dao.entities.Item;
import by.harashchenia.dao.entities.Receipt;
import by.harashchenia.dao.entities.StringInReceipt;
import by.harashchenia.dao.inMemoryStorage.StorageOfCards;
import by.harashchenia.dao.inMemoryStorage.StorageOfItems;
import by.harashchenia.service.api.IService;
import by.harashchenia.service.converter.FromMapArgsToItems;

import java.util.List;
import java.util.Map;

public class FromCommandLineService implements IService {
     private Map<String,String> commandLineArgs;
     private Card card;
    public FromCommandLineService(Map<String, String> commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }
    @Override
    public Card getCard(){
        Card card = new Card(0,0);
        if(commandLineArgs.containsKey("card")){
            Long id = Long.parseLong(commandLineArgs.get("card"));
            commandLineArgs.remove("card");
            StorageOfCards storageOfCards = new StorageOfCards();
            List<Card> cards = storageOfCards.getStorageOfCards();
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
        StorageOfItems storageOfItems = new StorageOfItems();
        List<Item> localStorageOfItems = storageOfItems.getStorageOfItems();
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
