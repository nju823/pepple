package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticMapper;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2018-04-18.
 */
@Service
public class ServiceStatisticServiceImpl implements ServiceStatisticService{

    @Autowired
    private ServiceStatisticMapper hourMapper;

    @Autowired
    private ServiceStatisticDayMapper dayMapper;

    @Override
    public List<ServiceStatisticVO> getSystemServiceStatistic(String sysName, String date) {
        return dayMapper.getStatisticBySystem(date,sysName);
    }

    @Override
    public ServiceStatisticVO getServiceStatistic(String date, String serviceName) {
        return dayMapper.getServiceStatistic(serviceName,date);
    }

    @Override
    public List<ServiceStatisticVO> getHourServiceStatistic(String date, String serviceName) {
        return hourMapper.getStatistic(date,serviceName);
    }

    @Override
    public List<ServiceStatisticVO> getWeekServiceStatistic(String date, String serviceName) {
        return dayMapper.getServiceStatisticBetween(serviceName, TimeUtil.lastWeek(date),date);
    }

    @Override
    public List<ServiceStatisticVO> getMonthServiceStatistic(String date, String serviceName) {
        return dayMapper.getServiceStatisticBetween(serviceName,TimeUtil.lastMonth(date),date);
    }

    @Override
    public ResponseDto hasStatistic(String serviceName, String date) {
        ServiceStatisticVO vo=dayMapper.getServiceStatistic(serviceName,date);
        ResponseDto responseDto=new ResponseDto();
        responseDto.setSuccess(vo!=null);
        return responseDto;
    }
}
