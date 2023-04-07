package cn.showcon.boot.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2023/4/7
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private String name;
    private String age;
}
