package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemSimpleInfoVO;
import nju.edu.cn.pepple.vo.SystemStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2018-04-11.
 */
@Service
public class HistoryStatisticServiceImpl implements HistoryStatisticService{

    @Autowired
    private SystemStatisticDayMapper dayMapper;

    @Override
    public List<SystemSimpleInfoVO> getAllSystemStatistic(String date) {
        List<ServiceStatisticVO> statisticVOS=dayMapper.getAllSystemStatistic(date);
        List<SystemSimpleInfoVO> simpleInfos=new ArrayList<SystemSimpleInfoVO>();
        for(ServiceStatisticVO statisticVO:statisticVOS){
            SystemSimpleInfoVO simpleInfo=new SystemSimpleInfoVO();
            simpleInfo.setAccessCount(statisticVO.getAccessCount());
            simpleInfo.setName(statisticVO.getSystem());
            double errorPercent=statisticVO.getErrorCount()/(double)statisticVO.getAccessCount();
            double successPercent=(1-errorPercent)*100;
            simpleInfo.setSuccessPercent((int)successPercent);

            simpleInfos.add(simpleInfo);
        }
        return simpleInfos;
    }
}
