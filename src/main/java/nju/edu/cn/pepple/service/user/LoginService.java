package nju.edu.cn.pepple.service.user;

import nju.edu.cn.pepple.dto.LoginDto;
import nju.edu.cn.pepple.dto.ResponseDto;

/**
 * Created by cong on 2018-02-10.
 */
public interface LoginService {

    /**
     * 登录
     * @param input
     * @return
     */
    public ResponseDto login(LoginDto input);

}
