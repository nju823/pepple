package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;

import java.util.List;

/**
 * Created by cong on 2018-04-18.
 */
public interface ServiceStatisticService {


    /**
     * 获取系统所有的接口
     * @param sysName
     * @param date
     * @return
     */
    public List<ServiceStatisticVO> getSystemServiceStatistic(String sysName,String date);

}
