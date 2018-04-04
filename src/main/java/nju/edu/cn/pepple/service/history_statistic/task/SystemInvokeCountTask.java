package nju.edu.cn.pepple.service.history_statistic.task;

import nju.edu.cn.pepple.mapper.history_statistic.SystemInvokeCountDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemInvokeCountMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cong on 2018-04-04.
 */
@Component
public class SystemInvokeCountTask {

    @Autowired
    private SystemInvokeCountMapper hourMapper;

    @Autowired
    private SystemInvokeCountDayMapper dayMapper;

    @Scheduled(cron = "0 0 4 * * ?")
    public void run(){
        String date= "2018-03-31";
        List<String> systems=hourMapper.getInvokedSystem(date);
        for(String system:systems){
            List<SystemInvokeCountVO> countVOS=hourMapper.getStatistic(date,system);
            Map<String,SystemInvokeCountVO> targetMap=new HashMap<String, SystemInvokeCountVO>();
            for(SystemInvokeCountVO countVO:countVOS){
                SystemInvokeCountVO sum=targetMap.get(countVO.getSourceSystem());
                if(sum==null)
                    targetMap.put(countVO.getSourceSystem(),countVO);
                else
                    sum.setInvokeCount(sum.getInvokeCount()+countVO.getInvokeCount());
            }
            for(SystemInvokeCountVO sum:targetMap.values()){
                dayMapper.insertSelective(sum);
            }
        }
    }

}
