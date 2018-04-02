package nju.edu.cn.pepple.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nju.edu.cn.pepple.model.Log;
import nju.edu.cn.pepple.model.Trace;

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

    public ArrayList<Trace> TraceSearchResultsArrayToList(String reuslt_str){
        ArrayList<Trace> traces = new ArrayList<Trace>();
        JSONArray traceArray = JSONObject.fromObject(reuslt_str).getJSONObject("aggregations").getJSONObject("aggTraceId").getJSONArray("buckets");
        for(int i=0;i<traceArray.size();i++){
            Trace temp = new Trace();
            temp.setTraceId(traceArray.getJSONObject(i).getString("key"));
            temp.setLogs(this.HitsArrayToListOfLog(traceArray.getJSONObject(i).getJSONObject("aggTraceIdTerms").getJSONObject("hits").getJSONArray("hits")));
            temp.findRoot();
            traces.add(temp);
        }
        return traces;
    }
}
