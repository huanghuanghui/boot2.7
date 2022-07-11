package cn.showcon.boot.contract;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 描述:表格数据
 * </p>
 *
 * @author hhh
 * @since 2022/6/8
 */
@Getter
@Setter
public class TableValue implements Serializable {

    private String name;
    private String value;
    private String text;
}
