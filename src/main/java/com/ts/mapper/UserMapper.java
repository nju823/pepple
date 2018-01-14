package com.ts.mapper;

import com.ts.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public void addUser(User user);

    public void updateToken(@Param("token") String token,@Param("email") String email);

    public void activeUser(String email);

    public User getUserByEmail(String email);

    public User getUserByStudentId(String studentId);
}
