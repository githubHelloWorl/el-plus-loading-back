package com.example.demo5_mybatis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo5_mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}


