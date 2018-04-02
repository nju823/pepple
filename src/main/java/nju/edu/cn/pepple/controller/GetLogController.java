package nju.edu.cn.pepple.controller;

import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.dto.searchDto;
import nju.edu.cn.pepple.service.log.getLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class GetLogController {

    @Autowired
    private getLogService logService;

    @RequestMapping(value = "/getLog")
    @ResponseBody
    public ResponseDto getLog(@RequestBody @Valid searchDto searchInfo){ return logService.searchLog(searchInfo);};

    @RequestMapping(value = "/getSystems")
    @ResponseBody
    public  ResponseDto getSystems(){ return logService.getSystems(); };

    @RequestMapping(value = "/getLogById")
    @ResponseBody
    public  ResponseDto getLogById(@RequestBody @Valid Long id){ return logService.getLogById(id); };
}
