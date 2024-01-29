package com.example.demo5_mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo5_mybatis.vo.CascaderVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName( value = "cascader")
public class Cascader {
    public Integer id;
    public String label;
    public String value;
    public Integer level;
    public Integer preId;
    public Integer childrenNum;

    public CascaderVo toVO() {
        CascaderVo vo = new CascaderVo();
        vo.setLabel(this.label);
        vo.setValue(this.value);
        vo.setLeaf(this.childrenNum == 0);
        return vo;
    }
}
