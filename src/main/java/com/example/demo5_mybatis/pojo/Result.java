package com.example.demo5_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(){
        return new Result<>(1,"successful",null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(1,"successful",data);
    }

    public static <T> Result<T> error(){
        return new Result<>(1,"error",null);
    }

    public static <T> Result<T> error(T data){
        return new Result<>(1,"error",data);
    }
}
