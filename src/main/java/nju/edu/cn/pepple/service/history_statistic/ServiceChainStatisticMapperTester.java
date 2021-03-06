package nju.edu.cn.pepple.service.history_statistic;

import com.alibaba.fastjson.JSONObject;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceChainStatisticMapper;

import nju.edu.cn.pepple.mapper.history_statistic.SystemStatisticDayMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cong on 2018-04-01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class ServiceChainStatisticMapperTester {

    @Autowired
    private ServiceChainStatisticMapper mapper;

    @Autowired
    private SystemStatisticDayMapper systemStatisticDayMapper;

    @Test
    public void getAllSystemStatistic(){
        System.out.println(JSONObject.toJSONString(systemStatisticDayMapper.getAllSystemStatistic("2018-03-31")));
    }

    @Test
    public void getInvokeServices(){
        System.out.println(mapper.getInvokedServices("2018-03-31"));
    }


}
