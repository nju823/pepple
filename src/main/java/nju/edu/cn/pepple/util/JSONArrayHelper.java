package nju.edu.cn.pepple.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nju.edu.cn.pepple.model.Log;

import java.util.ArrayList;

public class JSONArrayHelper {


    public ArrayList<String> jsonArrayToListOfKeyWord(JSONArray jsonArray, String key){
        ArrayList<String> result = new ArrayList<String>();
        for(int i =0;i<jsonArray.size();i++){
            String temp = jsonArray.getJSONObject(i).getString(key);
            if(!temp.equals(""))
                result.add(temp);
        }
        return result;
    }

    public ArrayList<Log> HitsArrayToListOfLog(JSONArray hitsArray){
        ArrayList<Log> result = new ArrayList<Log>();
        for(int i =0;i<hitsArray.size();i++){
            Log tempLog  = (Log) JSONObject.toBean(hitsArray.getJSONObject(i).getJSONObject("_source"),Log.class);
            result.add(tempLog);
        }
        return result;
    }
}
