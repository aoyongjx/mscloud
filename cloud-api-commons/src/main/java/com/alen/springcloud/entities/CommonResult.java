package com.alen.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json封装体CommonResult
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code; // 类似于404的编码
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}

