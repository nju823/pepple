package nju.edu.cn.pepple.controller.history;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.service.history_statistic.ServiceChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cong on 2018-04-24.
 */
@Controller
public class ServiceChainController {

    @Autowired
    private ServiceChainService serviceChainService;

    @RequestMapping("/service/chain/{root}/{date}")
    @ResponseBody
    public ResponseDto getChainStatistic(@PathVariable String root,@PathVariable String date){
        return serviceChainService.getChainStatistic(root,date);
    }

}
