package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 草拟要素关联书签信息
 * </p>
 *
 * @author hhh
 * @since 2022-06-20
 */
@Getter
@Setter
@Schema(name = "ContractMarkLinkResponse对象", description = "草拟要素关联书签信息")
public class ContractMarkLinkResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name = "前端选择要素文本长度",required = true)
    private Integer length;

    @Schema(name="字段（书签）名称，如contractCode/deadline")
    private String fieldName;

    @Schema(name="书签名称（例如合同名称1，合同名称2）")
    private String name;

    @Schema(name="文件ID(书签区分对应合同正文/附件文件，拥有自己的独立书签)")
    private String fileId;

    @Schema(name="书签名称-uuid，前端使用uuid与文件中的书签进行同步")
    private String fileMarkName;

    @Schema(name="租户ID")
    private String tenantId;

    @Schema(name="创建人id(0：系统生成,其他：账号id)")
    private Long creatorId;

    @Schema(name="创建人名称")
    private String creator;

    @Schema(name="创建时间")
    private Long createTime;

    @Schema(name="是否删除,0：未删除，时间戳：已删除")
    private Long deleted;


}
