package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.mapper.history_statistic.ServiceStatisticMapper;
import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2018-04-18.
 */
@Service
public class ServiceStatisticServiceImpl implements ServiceStatisticService{

    @Autowired
    private ServiceStatisticMapper mapper;

    @Override
    public List<ServiceStatisticVO> getSystemServiceStatistic(String sysName, String date) {
        return mapper.getStatisticBySystem(date,sysName);
    }
}
