package nju.edu.cn.pepple.controller.history;

import nju.edu.cn.pepple.service.history_statistic.HistoryStatisticService;
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
public class HistoryStatisticController {

    @Autowired
    private HistoryStatisticService historyStatisticService;

    /**
     * 获取所有系统的概览统计信息，最多返回十个
     * @return
     */
    @RequestMapping("/history/statistic/all/{date}")
    @ResponseBody
    public  List<SystemSimpleInfoVO> getAllSystemStatistic(@PathVariable String date){
        return historyStatisticService.getAllSystemStatistic(date);
    }

}
