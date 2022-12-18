package by.harashchenia.service.serviceFactory.api;

import by.harashchenia.service.api.IService;

public interface IServiceFactory {
    /**
     * determining the source of the order
     * @param args command Line args
     * @return service
     */
    IService getService(String[] args);
}
