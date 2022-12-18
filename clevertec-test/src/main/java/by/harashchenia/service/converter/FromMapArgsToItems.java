package by.harashchenia.service.converter;

import java.util.HashMap;
import java.util.Map;

public class FromMapArgsToItems {

    Map<String,String> commandLineArgs;

    public FromMapArgsToItems(Map<String, String> commandLineArgs) {
        this.commandLineArgs = commandLineArgs;
    }
    public Map<Long,Long> getIdAndQty(){
        Map<Long,Long> idAndQty = new HashMap<>();
        for (Map.Entry<String, String> stringEntry : commandLineArgs.entrySet()) {
            idAndQty.put(Long.parseLong(stringEntry.getKey()),Long.parseLong(stringEntry.getValue()));
        }
        return idAndQty;
    }
}
