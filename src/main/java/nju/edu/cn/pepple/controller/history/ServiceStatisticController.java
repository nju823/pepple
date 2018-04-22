package nju.edu.cn.pepple.controller.history;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.service.history_statistic.ServiceStatisticService;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cong on 2018-04-18.
 */
@Controller
public class ServiceStatisticController {

    @Autowired
    private ServiceStatisticService service;

    @RequestMapping("/history/service/statistic/system/{sysName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getSystemServiceStatistic(@PathVariable String sysName,@PathVariable String date){
        return service.getSystemServiceStatistic(sysName,date);
    }

    @RequestMapping("/history/service/statistic/has/{serviceName}/{date}")
    @ResponseBody
    public ResponseDto hasServiceStatistic(@PathVariable String serviceName, @PathVariable String date){
        return service.hasStatistic(serviceName,date);
    }

    @RequestMapping("/history/service/statistic/{serviceName}/{date}")
    @ResponseBody
    public ServiceStatisticVO getServiceStatistic(@PathVariable("serviceName") String serviceName,
                                                  @PathVariable("date") String date){
        System.out.println(serviceName);
        return service.getServiceStatistic(date,serviceName);
    }

    @RequestMapping("/history/service/statistic/hour/{serviceName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getHourServiceStatistic(@PathVariable("serviceName") String serviceName,
                                                            @PathVariable("date") String date){
        return service.getHourServiceStatistic(date,serviceName);
    }

    @RequestMapping("/history/service/statistic/week/{serviceName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getWeekServiceStatistic(@PathVariable("serviceName") String serviceName,
                                                            @PathVariable("date") String date){
        return service.getWeekServiceStatistic(date,serviceName);
    }

    @RequestMapping("/history/service/statistic/month/{serviceName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getMonthServiceStatistic(@PathVariable("serviceName") String serviceName,
                                                             @PathVariable("date") String date){
        return service.getMonthServiceStatistic(date,serviceName);
    }

}
