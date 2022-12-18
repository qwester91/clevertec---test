package by.harashchenia;

import by.harashchenia.dao.entities.Card;
import by.harashchenia.dao.entities.Receipt;
import by.harashchenia.service.api.IService;
import by.harashchenia.service.serviceFactory.ServiceFactory;

public class BillingApp {
    public static void main(String[] args) {
      ServiceFactory factory = new ServiceFactory();
      IService service = factory.getService(args);
        Card card = service.getCard();
        Receipt receipt = service.getReceipt();
        System.out.println(receipt);
    }
}