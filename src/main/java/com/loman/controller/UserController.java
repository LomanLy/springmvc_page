package com.loman.controller;

import com.loman.bean.User;
import com.loman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/4/18.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(1);
        mav.addObject("user",user);
        return mav;
    }
}
