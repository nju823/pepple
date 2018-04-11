package nju.edu.cn.pepple.service.history_statistic.task;

import nju.edu.cn.pepple.mapper.history_statistic.ServiceChainStatisticDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceChainStatisticMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceChainStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cong on 2018-04-02.
 */
@Component
public class ServiceChainTask {

    @Autowired
    private ServiceChainStatisticMapper hourMapper;

    @Autowired
    private ServiceChainStatisticDayMapper dayMapper;

    @Scheduled(cron = "0 0 4 * * ?")
    public void run(){
        String yesterday= TimeUtil.yesterday();
        List<String> serviceList=hourMapper.getInvokedServices(yesterday);

        for(String service:serviceList){//每个服务
            Map<String,ServiceChainStatisticVO> chainMap=new HashMap<String, ServiceChainStatisticVO>();
            List<ServiceChainStatisticVO> statisticVOS=hourMapper.getStatisticByDate(service,yesterday);
            for(ServiceChainStatisticVO statisticVO:statisticVOS){//分别统计每条调用链
                if(statisticVO.getRootService()==null)
                    continue;
                ServiceChainStatisticVO sum=chainMap.get(statisticVO.getRootService());
                if(sum==null){
                    chainMap.put(statisticVO.getRootService(),statisticVO);
                }else{
                    sum.add(statisticVO);
                }
            }

            for(ServiceChainStatisticVO sum:chainMap.values()){
                dayMapper.insertSelective(sum);
            }
        }
    }

}
