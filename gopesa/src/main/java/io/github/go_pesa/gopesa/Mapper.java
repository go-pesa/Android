package io.github.go_pesa.gopesa;


import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

import mgopesa.StkResponse;

/**
 * Created by clive on 22/10/17.
 */

final class Mapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> map(StkResponse stkResponse){
        @SuppressWarnings("unchecked")
        Map<String, Object> stkResponseMap = objectMapper.convertValue(stkResponse, Map.class);
        return stkResponseMap;
    }
}
