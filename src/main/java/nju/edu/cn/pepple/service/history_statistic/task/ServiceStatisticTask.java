package nju.edu.cn.pepple.service.history_statistic.task;

import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.StatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cong on 2018-04-04.
 */
@Component
public class ServiceStatisticTask {

    @Autowired
    private ServiceStatisticMapper hourMapper;

    @Autowired
    private ServiceStatisticDayMapper dayMapper;



    @Scheduled(cron = "0 0 4 * * ?")
    public void run(){
        String date= TimeUtil.yesterday();
        List<String> services=hourMapper.getInvokedServices(date);
        for(String service:services){
            List<ServiceStatisticVO> statisticVOs=hourMapper.getStatistic(date,service);
            saveDayStatistic(statisticVOs);

        }
    }

    /**
     * 合计单服务每天的统计量
     * @param statisticVOs
     */
    private void saveDayStatistic(List<ServiceStatisticVO> statisticVOs){
        ServiceStatisticVO sum=null;
        for(ServiceStatisticVO statisticVO:statisticVOs){
            if(sum==null)
                sum=statisticVO;
            else
                sum.add(statisticVO);
        }
        dayMapper.insertSelective(sum);
    }


}
