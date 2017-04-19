package com.loman.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loman.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface UserService {

    User selectUserById(Integer userId);

    PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize);

    List<User> selectUserByIdPage(Integer userId, Integer pageNo, Integer pageSize);
}
