package nju.edu.cn.pepple.controller.history;

import nju.edu.cn.pepple.service.history_statistic.InvokeCountService;
import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cong on 2018-04-17.
 */
@Controller
public class InvokeCountController {


    @Autowired
    private InvokeCountService service;


    @RequestMapping("/count/source/{system}/{date}")
    @ResponseBody
    public List<SystemInvokeCountVO> getInvokeSystemCount(@PathVariable String system,@PathVariable String date){
        return service.getInvokeSystemCount(system,date);
    }

    @RequestMapping("/count/target/{system}/{date}")
    @ResponseBody
    public List<SystemInvokeCountVO> getTargetSystemCount(@PathVariable String system,@PathVariable String date){
        return service.getTargetSystemCount(system,date);
    }

    @RequestMapping("/count/service/source/{serviceName}/{date}")
    @ResponseBody
    public List<ServiceInvokeCountVO> getInvokeServiceCount(@PathVariable String serviceName,@PathVariable String date){
        return service.getInvokeServiceCount(serviceName,date);
    }

    @RequestMapping("/count/service/target/{serviceName}/{date}")
    @ResponseBody
    public List<ServiceInvokeCountVO> getTargetServiceCount(@PathVariable String serviceName,@PathVariable String date){
        return service.getTargetServiceCount(serviceName,date);
    }

}
