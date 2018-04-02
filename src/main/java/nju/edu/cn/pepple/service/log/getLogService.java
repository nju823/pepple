package nju.edu.cn.pepple.service.log;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.dto.searchDto;

public interface getLogService {

    public ResponseDto searchLog(searchDto searchInfo);

    public ResponseDto getSystems();

    public ResponseDto getLogById(long id);
}
