package com.loman.dao;

import com.loman.bean.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@MapperScan
public interface UserDao {

    User selectUserById(Integer userId);
    List<User> selectUserByUserName(String userName);
    List<User> selectUserByIdPage(Integer userId);
}
