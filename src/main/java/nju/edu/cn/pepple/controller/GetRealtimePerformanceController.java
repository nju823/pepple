package nju.edu.cn.pepple.controller;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.dto.searchDto;
import nju.edu.cn.pepple.model.SystemMinutePerformance;
import nju.edu.cn.pepple.service.performance.RealtimePerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class GetRealtimePerformanceController {

    @Autowired
    private RealtimePerformanceService realtimePerformanceService;

    @RequestMapping(value = "/getServiceMinutePerformanceBySystemName")
    @ResponseBody
    public ResponseDto getServiceMinutePerformance(@Valid String systemName){ return realtimePerformanceService.getServiceMinutePerformanceBySystemName(systemName); }

    @RequestMapping(value = "/getAllSystemMinutePerformance")
    @ResponseBody
    public ResponseDto getAllSystemMinutePerformance(){return  realtimePerformanceService.getAllSystemMinutePerformance(); }

    @RequestMapping(value = "/getSystemDayPerformanceBySystemName")
    @ResponseBody
    public ResponseDto getSystemDayPerformanceByName(@Valid String systemName){ return realtimePerformanceService.getSystemDayPerformacneBySystemName(systemName); }

    @RequestMapping(value = "/getServiceDayPerformanceBySystemName")
    @ResponseBody
    public ResponseDto getServiceDayPerformanceByName(@Valid String serviceName){return realtimePerformanceService.getServiceDayPerformanceByServiceName(serviceName);}
}
