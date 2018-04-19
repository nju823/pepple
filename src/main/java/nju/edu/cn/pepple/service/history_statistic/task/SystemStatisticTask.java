package nju.edu.cn.pepple.service.history_statistic.task;


import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.StatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by cong on 2018-04-04.
 */
@Component
public class SystemStatisticTask {

    @Autowired
    private ServiceStatisticMapper hourMapper;

    @Autowired
    private SystemServiceStatisticMapper systemMapper;

    @Autowired
    private SystemStatisticDayMapper systemDayMapper;

    @Scheduled(cron = "0 0 4 * * ?")
    public void run(){
        String date= TimeUtil.yesterday();
        List<String> systems=hourMapper.getInvokedSystem(date);
        for(String system:systems){
            ServiceStatisticVO sum=null;
            Map<Integer,ServiceStatisticVO> hourMap=new HashMap<Integer,ServiceStatisticVO>();

            List<ServiceStatisticVO> statisticVOs=hourMapper.getStatisticBySystem(date,system);
            for(ServiceStatisticVO statisticVO:statisticVOs){
                if(sum==null)
                    sum=statisticVO.copy();
                else
                    sum.add(statisticVO);

                ServiceStatisticVO hourSum=hourMap.get(statisticVO.getHour());
                if(hourSum==null)
                    hourMap.put(statisticVO.getHour(),statisticVO.copy());
                else
                    hourSum.add(statisticVO);
            }
            systemDayMapper.insertSelective(sum);
            for(ServiceStatisticVO hourSum:hourMap.values()){
                systemMapper.insertSelective(hourSum);
            }
        }

    }

}
