package nju.edu.cn.pepple.service.history_statistic.task;

import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cong on 2018-04-02.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class TaskTester {

    @Autowired
    private ServiceChainTask serviceChainTask;

    @Autowired
    private ServiceInvokeCountTask serviceInvokeCountTask;

    @Autowired
    private ServiceStatisticTask serviceStatisticTask;

    @Autowired
    private SystemStatisticTask systemStatisticTask;

    @Autowired
    private SystemInvokeCountTask systemInvokeCountTask;

    @Test
    public void serviceChainTask(){
        serviceChainTask.run();
    }

    @Test
    public void serviceInvokeCountTask(){
        serviceInvokeCountTask.run();
    }

    @Test
    public void serviceStatisticTask(){
        serviceStatisticTask.run();
    }

    @Test
    public void systemStatisticTask(){
        systemStatisticTask.run();
    }

    @Test
    public void systemInvokeCountTask(){
        systemInvokeCountTask.run();
    }



}
