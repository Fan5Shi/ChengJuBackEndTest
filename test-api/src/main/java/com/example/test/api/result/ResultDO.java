package com.example.test.api.result;

import lombok.Data;

/**
 * 基本返回数据结构
 * @author Jilin He
 * @date 2020.1.15
 */
@Data
public class ResultDO {

    private String system;

    private int code;

    private String msg;

    private Object data;

    public ResultDO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDO(String system, int code, String msg, Object data) {
        this.system = system;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
