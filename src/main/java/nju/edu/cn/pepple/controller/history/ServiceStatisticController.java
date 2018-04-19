package nju.edu.cn.pepple.controller.history;

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


}
