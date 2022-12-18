package by.harashchenia.service.api;

import by.harashchenia.dao.entities.Card;
import by.harashchenia.dao.entities.Receipt;

public interface IService {
    public Card getCard();
    public Receipt getReceipt();
}
