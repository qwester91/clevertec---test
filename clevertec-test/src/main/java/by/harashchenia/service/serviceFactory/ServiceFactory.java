package by.harashchenia.service.serviceFactory;

import by.harashchenia.service.api.IService;
import by.harashchenia.service.FromCommandLineService;
import by.harashchenia.service.FromFileService;
import by.harashchenia.service.serviceFactory.api.IServiceFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ServiceFactory implements IServiceFactory {

    public IService getService(String[] args) {
        Map<String,String> commandLineArgs = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("-");
            commandLineArgs.put(split[0], split[1]);

        }
        if (!commandLineArgs.containsKey("filePath")){
            return new FromCommandLineService(commandLineArgs);
        }else return new FromFileService(commandLineArgs);


    }
}
