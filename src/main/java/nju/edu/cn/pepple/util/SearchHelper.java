package nju.edu.cn.pepple.util;

import net.sf.json.JSONObject;

public class SearchHelper {

    public JSONObject exactSearch(String fieldName,Object keyword){
        JSONObject result = new JSONObject();
        JSONObject field = new JSONObject();
        field.put(fieldName,keyword);
        result.put("term",field);
        return result;
    }

    public JSONObject fuzzySearch(String fieldName,String keyword){
        JSONObject result = new JSONObject();
        JSONObject field = new JSONObject();
        field.put(fieldName,".*"+keyword+".*");
        result.put("regexp",field);
        return result;
    }

}
