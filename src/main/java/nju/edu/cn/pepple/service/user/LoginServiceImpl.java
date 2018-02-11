package nju.edu.cn.pepple.service.user;

import nju.edu.cn.pepple.dto.LoginDto;
import nju.edu.cn.pepple.dto.ResponseDto;
import nju.edu.cn.pepple.mapper.UserMapper;
import nju.edu.cn.pepple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2018-02-10.
 */
@Service
public class LoginServiceImpl implements LoginService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseDto login(LoginDto input) {
        User user= userMapper.getUserByName(input.getUsername());
        if(user==null)
            return ResponseDto.buildFailure("用户不存在");
        if(!user.getPassword().equals(input.getPassword()))
            return ResponseDto.buildFailure("密码错误");
        return ResponseDto.buildSuccess(user);
    }
}
