package nju.edu.cn.pepple.service.log;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.dto.searchDto;
import nju.edu.cn.pepple.model.Trace;
import nju.edu.cn.pepple.util.JSONArrayHelper;
import nju.edu.cn.pepple.util.SearchHelper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

@Service
public class getLogServiceImpl implements getLogService {

    JSONArrayHelper jsonArrayHelper = new JSONArrayHelper();
    SearchHelper searchHelper = new SearchHelper();

    @Override
    public ResponseDto searchLog(searchDto searchInfo) {
        System.out.println("getlog");
        //用JSONobject构造查询语句
        JSONObject query = new JSONObject();
        JSONObject bool = new JSONObject();
        JSONObject must_should = new JSONObject();
        JSONArray mustArray = new JSONArray();
        JSONArray shouldArray = new JSONArray();
        JSONObject rangeReq = new JSONObject();
        JSONObject rangeRes = new JSONObject();
        JSONObject termsSource = new JSONObject();
        JSONObject termsTarget = new JSONObject();
        JSONObject termsType = new JSONObject();

        //时间过滤
        JSONObject requestCurrentMillis = new JSONObject();
        JSONObject responseCurrentMillis = new JSONObject();
        JSONObject gte = new JSONObject();
        JSONObject lte = new JSONObject();
        gte.put("gte",searchInfo.getStartTime());
        lte.put("lte",searchInfo.getEndTime());
        requestCurrentMillis.put("requestCurrentMillis",gte);
        responseCurrentMillis.put("responseCurrentMillis",lte);
        rangeReq.put("range",requestCurrentMillis);
        rangeRes.put("range",responseCurrentMillis);
        mustArray.add(rangeReq);
        mustArray.add(rangeRes);

        //系统过滤
        JSONObject source = new JSONObject();
        JSONObject target = new JSONObject();
        source.put("source",searchInfo.getSystems());
        target.put("target",searchInfo.getSystems());
        termsSource.put("terms",source);
        termsTarget.put("terms",target);
        shouldArray.add(termsSource);
        shouldArray.add(termsTarget);

        //类型过滤
        JSONObject type = new JSONObject();
        type.put("type",searchInfo.getTypes());
        termsType.put("terms",type);
        mustArray.add(termsType);

        //字符串过滤
        if(!searchInfo.getLogServiceName().equals("")){
            mustArray.add(searchHelper.fuzzySearch("serviceName",searchInfo.getLogServiceName()));
        }
        if(!searchInfo.getLogServiceUrl().equals("")){
            mustArray.add(searchHelper.fuzzySearch("serviceUrl",searchInfo.getLogServiceUrl()));
        }
        if(!searchInfo.getLogParam().equals("")){
            mustArray.add(searchHelper.fuzzySearch("content",searchInfo.getLogParam()));
        }

        //完成搜索条件
        must_should.put("must_not",JSONObject.fromObject("{\"term\":{\"requestCurrentMillis\":0}}"));
        must_should.put("must",mustArray);
        must_should.put("should",shouldArray);
        bool.put("bool",must_should);
        query.put("query",bool);

        String aggStr = "{\n" +
                "\t\t\"aggTraceId\":{\n" +
                "\t\t\t\"terms\":{\n" +
                "\t\t\t\t\"field\":\"traceId\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"aggs\":{\n" +
                "\t\t\t\t\"aggTraceIdTerms\":{\n" +
                "\t\t\t\t\t\"top_hits\":{\n" +
                "\t\t\t\t\t\t\"_source\":{\n" +
                "\t\t\t\t\t\t\t\"includes\":[\"traceId\",\"spanId\",\"parentSpanId\",\"type\",\"source\",\"target\",\"serviceName\",\"serviceUrl\",\"requestCurrentMillis\",\"responseCurrentMillis\",\"requestContent\",\"responseContent\",\"time\"]\n" +
                "\t\t\t\t\t\t}\n" +
                ",\"size\":9999"+
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}";
        JSONObject agg = JSONObject.fromObject(aggStr);
        query.put("aggs",agg);

        System.out.println("搜索条件 "+query.toString());
        String search_result_str=sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody="+query.toString());
        System.out.println(search_result_str);
        return ResponseDto.buildSuccess(jsonArrayHelper.TraceSearchResultsArrayToList(search_result_str));
    }

    @Override
    public ResponseDto getSystems() {
        String source_systems_str=sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody={\"size\":0,\"aggs\":{\"src_systems\":{\"terms\":{\"field\":\"source\"}}}}");
        String target_systems_str=sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody={\"size\":0,\"aggs\":{\"tgt_systems\":{\"terms\":{\"field\":\"target\"}}}}");
        JSONObject source_systems_obj = JSONObject.fromObject(source_systems_str);
        JSONObject target_systems_obj = JSONObject.fromObject(target_systems_str);
        ArrayList<String> source_systems = jsonArrayHelper.jsonArrayToListOfKeyWord(JSONArray.fromObject(source_systems_obj.getJSONObject("aggregations").getJSONObject("src_systems").getJSONArray("buckets")),"key");
        ArrayList<String> target_systems = jsonArrayHelper.jsonArrayToListOfKeyWord(JSONArray.fromObject(target_systems_obj.getJSONObject("aggregations").getJSONObject("tgt_systems").getJSONArray("buckets")),"key");
        ArrayList<String> union_systems = new ArrayList<String>();
        //求两个系统的并集
        union_systems.addAll(source_systems);
        union_systems.removeAll(target_systems);
        union_systems.addAll(target_systems);
        System.out.println("系统并集："+union_systems);
        return ResponseDto.buildSuccess(union_systems);
    }

    @Override
    public ResponseDto getLogById(long id) {


        String traceIdQueryStr = "{\n" +
                "\t\"query\": {\n" +
                "\t\t\"bool\": {\n" +
                "\t\t\t\"must\": {\n" +
                "\t\t\t\t\"term\": {\n" +
                "\t\t\t\t\t\"traceId\": "+id+"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                ",\"must_not\":{\"term\":{\"requestCurrentMillis\":0}}"+
                "\t\t}\n" +
                "\t},\n" +
                "\n" +
                "\t\"aggs\": {\n" +
                "\t\t\"aggTraceId\": {\n" +
                "\t\t\t\"terms\": {\n" +
                "\t\t\t\t\"field\": \"traceId\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"aggs\": {\n" +
                "\t\t\t\t\"aggTraceIdTerms\": {\n" +
                "\t\t\t\t\t\"top_hits\": {\n" +
                "\t\t\t\t\t\t\"_source\": {\n" +
                "\t\t\t\t\t\t\t\"includes\": [\n" +
                "\t\t\t\t\t\t\t\t\"traceId\",\n" +
                "\t\t\t\t\t\t\t\t\"spanId\",\n" +
                "\t\t\t\t\t\t\t\t\"parentSpanId\",\n" +
                "\t\t\t\t\t\t\t\t\"type\",\n" +
                "\t\t\t\t\t\t\t\t\"source\",\n" +
                "\t\t\t\t\t\t\t\t\"target\",\n" +
                "\t\t\t\t\t\t\t\t\"serviceName\",\n" +
                "\t\t\t\t\t\t\t\t\"serviceUrl\",\n" +
                "\t\t\t\t\t\t\t\t\"requestCurrentMillis\",\n" +
                "\t\t\t\t\t\t\t\t\"responseCurrentMillis\",\n" +
                "\t\t\t\t\t\t\t\t\"requestContent\",\n" +
                "\t\t\t\t\t\t\t\t\"responseContent\",\n" +
                "\t\t\t\t\t\t\t\t\"time\"\n" +
                "\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t}\n" +
                ",\"size\":9999"+
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        String traceIdResultStr = sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody="+traceIdQueryStr.toString());
        ArrayList<Trace> traceOfTraceId = jsonArrayHelper.TraceSearchResultsArrayToList(traceIdResultStr);
        if (traceOfTraceId.size()>0)
            return ResponseDto.buildSuccess(traceOfTraceId);

        //寻找spanid的traceId
        String spanIdQueryStr_TraceId = "{\"query\":{\"term\":{\"spanId\":"+id+"}}}";
        String findTraceIdResultStr = sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody="+spanIdQueryStr_TraceId.toString());

        if(JSONObject.fromObject(findTraceIdResultStr).getJSONObject("hits").getInt("total")==0){
            return ResponseDto.buildFailure("没有相同span/trace id的日志记录");
        }else{
            long traceIdOfSpanId = JSONObject.fromObject(findTraceIdResultStr).getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").getLong("traceId");
            String spanIdQueryStr = "{\n" +
                    "\t\"query\": {\n" +
                    "\t\t\"bool\": {\n" +
                    "\t\t\t\"must\": {\n" +
                    "\t\t\t\t\"term\": {\n" +
                    "\t\t\t\t\t\"traceId\": "+traceIdOfSpanId+"\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    ",\"must_not\":{\"term\":{\"requestCurrentMillis\":0}}"+
                    "\t\t}\n" +
                    "\t},\n" +
                    "\n" +
                    "\t\"aggs\": {\n" +
                    "\t\t\"aggTraceId\": {\n" +
                    "\t\t\t\"terms\": {\n" +
                    "\t\t\t\t\"field\": \"traceId\"\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"aggs\": {\n" +
                    "\t\t\t\t\"aggTraceIdTerms\": {\n" +
                    "\t\t\t\t\t\"top_hits\": {\n" +
                    "\t\t\t\t\t\t\"_source\": {\n" +
                    "\t\t\t\t\t\t\t\"includes\": [\n" +
                    "\t\t\t\t\t\t\t\t\"traceId\",\n" +
                    "\t\t\t\t\t\t\t\t\"spanId\",\n" +
                    "\t\t\t\t\t\t\t\t\"parentSpanId\",\n" +
                    "\t\t\t\t\t\t\t\t\"type\",\n" +
                    "\t\t\t\t\t\t\t\t\"source\",\n" +
                    "\t\t\t\t\t\t\t\t\"target\",\n" +
                    "\t\t\t\t\t\t\t\t\"serviceName\",\n" +
                    "\t\t\t\t\t\t\t\t\"serviceUrl\",\n" +
                    "\t\t\t\t\t\t\t\t\"requestCurrentMillis\",\n" +
                    "\t\t\t\t\t\t\t\t\"responseCurrentMillis\",\n" +
                    "\t\t\t\t\t\t\t\t\"requestContent\",\n" +
                    "\t\t\t\t\t\t\t\t\"responseContent\",\n" +
                    "\t\t\t\t\t\t\t\t\"time\"\n" +
                    "\t\t\t\t\t\t\t]\n" +
                    "\t\t\t\t\t\t}\n" +
                    ",\"size\":9999"+
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "}";

            String spanIdResultStr = sendPost("http://47.100.34.12:1346/searchdata/", "index=log_index&type=log_table&searchbody="+spanIdQueryStr.toString());
            System.out.println(spanIdQueryStr);
            System.out.println(spanIdResultStr);
            ArrayList<Trace> traceOfSpanId = jsonArrayHelper.TraceSearchResultsArrayToList(spanIdResultStr);
                return ResponseDto.buildSuccess(traceOfSpanId);
        }
    }


    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
