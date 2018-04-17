package nju.edu.cn.pepple.service.history_statistic.task;

import nju.edu.cn.pepple.mapper.history_statistic.ServiceInvokeCountDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceInvokeCountMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.InvokeKey;
import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cong on 2018-04-03.
 */
@Component
public class ServiceInvokeCountTask {


    @Autowired
    private ServiceInvokeCountMapper hourMapper;

    @Autowired
    private ServiceInvokeCountDayMapper dayMapper;



    @Scheduled(cron = "0 0 4 * * ?")
    public void run(){
        String date= TimeUtil.yesterday();
        List<String> services=hourMapper.getInvokedService(date);
        for(String service:services){//统计每一个接口
            List<ServiceInvokeCountVO> countVOS=hourMapper.getStatistic(date,service);
            Map<InvokeKey,ServiceInvokeCountVO> parentServiceMap=new HashMap<InvokeKey, ServiceInvokeCountVO>();
            for (ServiceInvokeCountVO countVO:countVOS){
                InvokeKey key=new InvokeKey(countVO.getParentService(),countVO.getService());
                ServiceInvokeCountVO sum=parentServiceMap.get(key);
                if(sum==null)
                    parentServiceMap.put(key,countVO);
                else
                    sum.setCount(sum.getCount()+countVO.getCount());
            }
            for(ServiceInvokeCountVO sum:parentServiceMap.values()){
                dayMapper.insertSelective(sum);
            }
        }
    }

}
