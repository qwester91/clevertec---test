package by.harashchenia.dao.inMemoryStorage.api;

import by.harashchenia.dao.entities.Card;

import java.util.List;

public interface IInMemoryStorage <T>{
         List<T> getStorage();
}
