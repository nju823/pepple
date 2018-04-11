package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.vo.SystemSimpleInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2018-04-11.
 */
public interface HistoryStatisticService {

    /**
     * 获取所有系统的简略信息，最多十个
     * @return
     */
    public List<SystemSimpleInfoVO> getAllSystemStatistic(String date);


}
