package com.loman.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loman.bean.User;
import com.loman.dao.UserDao;
import com.loman.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    public PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize) {

        int pageNoInt = pageNo == null ? 1 : pageNo;
        int pageSizeInt = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNoInt, pageSizeInt);
        List<User> list = userDao.selectUserByUserName(userName);
        PageInfo<User> page = new PageInfo<>(list);
        System.out.println("PageNu"+page.getPageNum());
        System.out.println("PageSi"+page.getPageSize());
        System.out.println("StartR"+page.getStartRow());
        System.out.println("EndRow"+page.getEndRow());
        System.out.println("Total("+page.getTotal());
        System.out.println("Pages("+page.getPages());
        System.out.println("FirstP"+page.getFirstPage());
        System.out.println("LastPa"+page.getLastPage());
        System.out.println("asPrev"+page.isHasPreviousPage());
        System.out.println("asNext"+page.isHasNextPage());
        System.out.println("List()"+page.getList());
        System.out.println("List-----"+list.get(1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getUserName()+ "========= "+i);
        }

        return page;
    }

    @Override
    public List<User> selectUserByIdPage(Integer userId, Integer pageNo, Integer pageSize) {
        int pageNoInt = pageNo == null ? 1 : pageNo;
        int pageSizeInt = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNoInt, pageSizeInt);
        List<User> list = userDao.selectUserByIdPage(userId);
        return list;
    }


}
