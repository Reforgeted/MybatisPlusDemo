package com.lu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lu.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  UserMapper extends BaseMapper<User> {
}

