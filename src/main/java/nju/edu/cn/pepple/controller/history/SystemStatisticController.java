package nju.edu.cn.pepple.controller.history;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.service.history_statistic.SystemStatisticService;
import nju.edu.cn.pepple.util.TimeUtil;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemSimpleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cong on 2018-04-11.
 */
@Controller
public class SystemStatisticController {

    @Autowired
    private SystemStatisticService historyStatisticService;

    /**
     * 获取所有系统的概览统计信息，最多返回十个
     * @return
     */
    @RequestMapping("/history/statistic/all")
    @ResponseBody
    public  List<SystemSimpleInfoVO> getAllSystemStatistic(){
        String date= TimeUtil.yesterday();
        return historyStatisticService.getAllSystemStatistic(date);
    }

    @RequestMapping("/history/statistic/{sysName}/{date}")
    @ResponseBody
    public ServiceStatisticVO getStatistic(@PathVariable("sysName") String sysName,@PathVariable String date){
        return historyStatisticService.getSystemStatistic(date,sysName);
    }

    @RequestMapping("/history/statistic/hour/{sysName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getHourStatistic(@PathVariable("sysName") String sysName,@PathVariable String date){
        return historyStatisticService.getHourSystemStatistic(date,sysName);
    }

    @RequestMapping("/history/statistic/week/{sysName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getWeekStatistic(@PathVariable("sysName") String sysName,@PathVariable String date){
        return historyStatisticService.getWeekSystemStatistic(date,sysName);
    }

    @RequestMapping("/history/statistic/month/{sysName}/{date}")
    @ResponseBody
    public List<ServiceStatisticVO> getMonthStatistic(@PathVariable("sysName") String sysName,@PathVariable String date){
        return historyStatisticService.getMonthSystemStatistic(date,sysName);
    }

    @RequestMapping("/history/statistic/has/{sysName}/{date}")
    @ResponseBody
    public ResponseDto hasStatistic(@PathVariable("sysName") String sysName,@PathVariable String date){
        return historyStatisticService.hasStatistic(date,sysName);
    }

}
