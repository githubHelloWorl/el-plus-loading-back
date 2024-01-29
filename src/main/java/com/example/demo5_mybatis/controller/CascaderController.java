package com.example.demo5_mybatis.controller;

import ch.qos.logback.core.pattern.ConverterUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.example.demo5_mybatis.entity.Cascader;
import com.example.demo5_mybatis.entity.User;
import com.example.demo5_mybatis.mapper.CascaderMapper;
import com.example.demo5_mybatis.service.CascaderService;
import com.example.demo5_mybatis.utils.ConvertUtil;
import com.example.demo5_mybatis.vo.CascaderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo5_mybatis.pojo.Result;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CascaderController {
    @Autowired
    private CascaderService cascaderService;

    @Autowired
    private CascaderMapper cascaderMapper;

    @PostMapping("/test1")
    public Result test1(@RequestParam(value = "level") Integer level) {
        System.out.println("level = " + level);
        LambdaQueryWrapper<Cascader> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(Cascader::getLevel, level);

        return Result.success(cascaderMapper.selectList(lambdaQueryWrapper));
    }

    @PostMapping("/test2")
    public Result<List<Cascader>> test2(@RequestParam("level") Integer level) {
        QueryWrapper<Cascader> queryWrapper = Wrappers.query();
        queryWrapper.eq("level", level);

        return Result.success(cascaderMapper.selectList(queryWrapper));
    }

    @GetMapping("/test3")
    public Result test3(@RequestParam(value = "level") Integer level){
        QueryWrapper<Cascader> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level",level);
        List<Cascader> list = cascaderMapper.selectList(queryWrapper);

        List<CascaderVo> cascaderVo = ConvertUtil.entityToVoList(list,CascaderVo.class);

        return Result.success(cascaderVo);
    }

    @GetMapping("/test4")
    public Result test4(@RequestParam(value = "level") Integer level){
        QueryWrapper<Cascader> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level",level);

        List<Cascader> list = cascaderMapper.selectList(queryWrapper);
        List<CascaderVo> listVo = new ArrayList<>(list.size());

        for(Cascader cascader: list){
            listVo.add(cascader.toVO());
        }

        return Result.success(listVo);
    }
}
