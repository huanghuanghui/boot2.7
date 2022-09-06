package cn.showcon.boot;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/9/5
 */
@Getter
@Setter
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;

}
