package nju.edu.cn.pepple.mapper;

import nju.edu.cn.pepple.model.ServiceMinutePerformance;
import nju.edu.cn.pepple.model.SystemMinutePerformance;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RealtimePerformanceMapper {
    public List<ServiceMinutePerformance> getServiceMinutePerformanceBySystemName(String systemName);

    public List<SystemMinutePerformance> getAllSystemMinutePerformance();

    public List<SystemMinutePerformance> getSystemDayPerformacneBySystemName(String systemName, String from,String to);

    public List<ServiceMinutePerformance> getServiceDayPerformanceByServiceName(String serviceName, String from,String to);
}
