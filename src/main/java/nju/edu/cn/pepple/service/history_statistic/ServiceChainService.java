package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.dto.ResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cong on 2018-04-24.
 */
public interface ServiceChainService {


    public ResponseDto getChainStatistic(String root,String date);

}
