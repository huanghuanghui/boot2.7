package cn.showcon.boot.response;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/11/16
 */
@Getter
@Setter
public class MyResponse {
    private Integer code;
    private String msg;

    public MyResponse() {
    }

    public MyResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
