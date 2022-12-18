package by.harashchenia.service.converter;

import by.harashchenia.service.converter.api.IConverter;

import java.util.HashMap;
import java.util.Map;

public class FromMapArgsToItems implements IConverter {

    Map<String,String> commandLineArgs;

    public FromMapArgsToItems(Map<String, String> commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }
    @Override
    public Map<Long,Long> getIdAndQty(){
        Map<Long,Long> idAndQty = new HashMap<>();
        for (Map.Entry<String, String> stringEntry : commandLineArgs.entrySet()) {
            idAndQty.put(Long.parseLong(stringEntry.getKey()),Long.parseLong(stringEntry.getValue()));
        }
        return idAndQty;
    }
}
