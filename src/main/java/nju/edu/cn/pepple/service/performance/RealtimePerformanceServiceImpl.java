package nju.edu.cn.pepple.service.performance;

import nju.edu.cn.pepple.dto.ResponseDto;

import nju.edu.cn.pepple.mapper.RealtimePerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class RealtimePerformanceServiceImpl implements RealtimePerformanceService{

    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String from  = sdf.format(now);
    String to = sdf.format(new Date(now.getTime()+24*60*60*1000));

    @Autowired
    RealtimePerformanceMapper realtimePerformanceMapper;

    @Override
    public ResponseDto getServiceMinutePerformanceBySystemName(String systemName) {
        return ResponseDto.buildSuccess(realtimePerformanceMapper.getServiceMinutePerformanceBySystemName(systemName));
    }

    @Override
    public ResponseDto getAllSystemMinutePerformance() {
        return ResponseDto.buildSuccess(realtimePerformanceMapper.getAllSystemMinutePerformance());
    }

    @Override
    public ResponseDto getSystemDayPerformacneBySystemName(String systemName) {
        System.out.println(from+"-"+to);
        System.out.println(systemName);
        return ResponseDto.buildSuccess(realtimePerformanceMapper.getSystemDayPerformacneBySystemName(systemName,from,to));
    }

    @Override
    public ResponseDto getServiceDayPerformanceByServiceName(String serviceName) {
        return ResponseDto.buildSuccess(realtimePerformanceMapper.getServiceDayPerformanceByServiceName(serviceName,from,to));
    }
}
