package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.mapper.history_statistic.SystemServiceStatisticMapper;
import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemSimpleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2018-04-11.
 */
@Service
public class SystemStatisticServiceImpl implements SystemStatisticService {

    @Autowired
    private SystemStatisticDayMapper dayMapper;

    @Autowired
    private SystemServiceStatisticMapper hourMapper;

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

    @Override
    public ServiceStatisticVO getSystemStatistic(String date, String sysName) {
        return dayMapper.getSystemStatistic(sysName,date);
    }

    @Override
    public List<ServiceStatisticVO> getHourSystemStatistic(String date, String sysName) {
        return hourMapper.getHourStatistic(sysName,date);
    }

    @Override
    public List<ServiceStatisticVO> getWeekSystemStatistic(String date, String sysName) {
        String lastWeek= TimeUtil.lastWeek(date);
        return dayMapper.getSystemStatisticWeek(sysName,lastWeek,date);
    }

    @Override
    public List<ServiceStatisticVO> getMonthSystemStatistic(String date, String sysName) {
        String lastWeek= TimeUtil.lastMonth(date);
        return dayMapper.getSystemStatisticWeek(sysName,lastWeek,date);
    }

    @Override
    public ResponseDto hasStatistic(String date, String sysName) {
        ServiceStatisticVO vo=dayMapper.getSystemStatistic(sysName,date);
        if(vo==null)
            return ResponseDto.buildFailure("缺少数据");
        return ResponseDto.buildSuccess();
    }
}
