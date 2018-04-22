package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.dto.ResponseDto;
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

    /**
     * 获取某天的统计
     * @param date
     * @return
     */
    public ServiceStatisticVO getServiceStatistic(String date,String ServiceName);

    /**
     * 获取一天各个小时的统计
     * @param date
     * @return
     */
    public List<ServiceStatisticVO> getHourServiceStatistic(String date,String serviceName);

    /**
     * 获取一周统计
     * @param date
     * @return
     */
    public List<ServiceStatisticVO> getWeekServiceStatistic(String date,String serviceName);

    /**
     * 获取一月统计
     * @param date
     * @return
     */
    public List<ServiceStatisticVO> getMonthServiceStatistic(String date,String serviceName);

    /**
     * 是否有统计数据
     * @param date
     * @return
     */
    public ResponseDto hasStatistic(String serviceName,String date);

}
