package by.harashchenia.service;

import by.harashchenia.dao.entities.Card;
import by.harashchenia.dao.entities.Receipt;
import by.harashchenia.service.api.IService;

import java.util.Map;

public class FromFileService implements IService {
    Map<String,String> commandLineArgs;

    public FromFileService(Map<String, String> commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public Receipt getReceipt() {
        return null;
    }
}
