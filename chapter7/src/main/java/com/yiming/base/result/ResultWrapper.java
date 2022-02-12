package com.yiming.base.result;

import com.yiming.base.enums.StateCodeEnums;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Program: spring-boot_demo
 * @Description:
 * @Author: YiMing
 * @Created: 2022/02/12 0:31
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 传输的数据
     */
    private T data;

    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.SUCCESS.getCode()).msg(StateCodeEnums.SUCCESS.getMsg());
    }

    public static ResultWrapper.ResultWrapperBuilder getFailedBuilder() {
        return ResultWrapper.builder().code(StateCodeEnums.FAILED.getCode()).msg(StateCodeEnums.FAILED.getMsg());
    }

}
