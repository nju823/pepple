package nju.edu.cn.pepple.service.performance;

import nju.edu.cn.pepple.dto.ResponseDto;

public interface RealtimePerformanceService {

    ResponseDto getServiceMinutePerformanceBySystemName(String systemName);

    ResponseDto getAllSystemMinutePerformance();

    ResponseDto getSystemDayPerformacneBySystemName(String systemName);

    ResponseDto getServiceDayPerformanceByServiceName(String serviceName);
}
