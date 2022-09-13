package cn.showcon.boot;

public class MyResponse {
    private Integer code;
    private String msg;

    public MyResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}