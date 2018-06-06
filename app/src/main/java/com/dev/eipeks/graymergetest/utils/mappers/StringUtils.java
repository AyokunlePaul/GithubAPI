package com.dev.eipeks.graymergetest.utils.mappers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StringUtils {
    public static Map<String, String> buildMyQuery(String os, String language, String sort, String order){
        Map<String, String> queryMap = new HashMap<>();
        String languageAndOs = String.format(Locale.ENGLISH, "%s+language:%s", os, language);
        queryMap.put("q", languageAndOs);
        queryMap.put("sort", sort);
        queryMap.put("order", order);

        return queryMap;
    }
}
