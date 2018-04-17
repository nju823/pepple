package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.mapper.history_statistic.SystemInvokeCountDayMapper;
import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2018-04-16.
 */
@Service
public class InvokeCountServiceImpl implements InvokeCountService{

    @Autowired
    private SystemInvokeCountDayMapper dayMapper;

    @Override
    public List<SystemInvokeCountVO> getInvokeSystemCount(String system, String date) {
        return dayMapper.getInvokeSystemCount(system,date);
    }

    @Override
    public List<SystemInvokeCountVO> getTargetSystemCount(String system, String date) {
        return dayMapper.getTargetSystemCount(system,date);
    }
}
