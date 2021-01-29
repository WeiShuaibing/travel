package com.bishe.travel.entity;

/**
 * 前后端交互实体类
 */
public class R {

    private int code = 20000;

    private String msg = "success";

    private Object data;

    public R(){}

    public R(Object data){
        this.data = data;
    }

    public R(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
