package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceChainStatisticDayMapper;
import nju.edu.cn.pepple.mapper.history_statistic.ServiceChainStatisticMapper;
import nju.edu.cn.pepple.vo.ChainStatisticShowVO;
import nju.edu.cn.pepple.vo.ServiceChainStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2018-04-24.
 */
@Service
public class ServiceChainServiceImpl implements ServiceChainService{

    @Autowired
    private ServiceChainStatisticDayMapper mapper;


    @Override
    public ResponseDto getChainStatistic(String root,String date) {
        ChainStatisticShowVO showVO=new ChainStatisticShowVO();
        List<ServiceChainStatisticVO> data=mapper.getChainStatistic(root,date);
        if(data.isEmpty())
            return ResponseDto.buildFailure("无数据");
        showVO.setChain(data);

        for(ServiceChainStatisticVO service:data){
            if(root.equals(service.getService())){
                showVO.setRoot(service);
                break;
            }
        }

        return ResponseDto.buildSuccess(showVO);
    }
}
