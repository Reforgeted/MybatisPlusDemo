package com.lu;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.dao.User;
import com.lu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@SpringBootTest
public class TestDemo {

    @Autowired
    UserMapper userMapper;
    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(3L);
        user.setName("Will");
        user.setAge(12);
        int count = userMapper.insert(user);
        System.out.println(count);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(3L);
        user.setEmail("lost@mail.com");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test// 条件查询
    public void conditionQuery(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //  ge,gt,le,lt
        //  queryWrapper.ge("age",18);

        //  eq,ne
        //  queryWrapper.ne("name", "lucy");

        //  between,notBetween
        //  queryWrapper.between("age", 17, 20);

        //  like,notLike,likeLeft,likeRight
        queryWrapper.like("name", "l");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    //  分页查询
    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1, 2);
        Page<User> userPage = userMapper.selectPage(page, null);
        userPage.getPages();//  总页数
        userPage.getCurrent();//    当前页数
        List<User> records = userPage.getRecords();//    数据集合
        userPage.getTotal();//  总记录数
        userPage.hasNext();//   下一页
        userPage.hasPrevious();//   上一页

        System.out.println(records);
    }

    @Test
    public void logicDelete(){
        userMapper.deleteById(3L);
        findAll();
    }
}
