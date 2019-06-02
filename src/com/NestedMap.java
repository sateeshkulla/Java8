package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class NestedMap {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        
        /**
         * { "key": 3, "foo": { "a": 5, "bar": { "baz": 8 } } }
         * 
         * { "key": 3, "foo.a": 5, "foo.bar.baz": 8 }
         */
        
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<String, Object>();
        
        String json = "{ \"key\": 3, \"foo\": { \"a\": 5, \"bar\": { \"baz\": 8 } } }";

        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
        
        for(String key : map.keySet()){
           Object val =  map.get(key);
           if(val instanceof Integer){
               System.out.println(key + ":" + val);
           }
        }

    }

}
