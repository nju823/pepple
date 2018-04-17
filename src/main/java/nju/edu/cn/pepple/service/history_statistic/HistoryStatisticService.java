package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
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


    /**
     * 获取某个系统某天的统计
     * @param date
     * @param sysName
     * @return
     */
    public ServiceStatisticVO getSystemStatistic(String date,String sysName);

    /**
     * 获取一天各个小时的统计
     * @param date
     * @param sysName
     * @return
     */
    public List<ServiceStatisticVO> getHourSystemStatistic(String date,String sysName);

    /**
     * 获取一周统计
     * @param date
     * @param sysName
     * @return
     */
    public List<ServiceStatisticVO> getWeekSystemStatistic(String date,String sysName);

    /**
     * 获取一月统计
     * @param date
     * @param sysName
     * @return
     */
    public List<ServiceStatisticVO> getMonthSystemStatistic(String date,String sysName);
}
