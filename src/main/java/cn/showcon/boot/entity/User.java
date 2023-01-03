package cn.showcon.boot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/12/15
 */
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String name;
    private Integer age;

}
