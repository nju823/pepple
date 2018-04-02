package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.SystemStatisticVO;

public interface SystemServiceStatisticMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemStatisticVO record);

    int insertSelective(SystemStatisticVO record);

    SystemStatisticVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemStatisticVO record);

    int updateByPrimaryKey(SystemStatisticVO record);
}