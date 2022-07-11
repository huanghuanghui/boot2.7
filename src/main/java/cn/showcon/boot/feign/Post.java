package cn.showcon.boot.feign;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/6/27
 */
@Getter
@Setter
public class Post implements Serializable {

    private Long userId;
    private Long id;
    private String title;
    private String body;
}
