package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 合同状态流转信息表
 * </p>
 *
 * @author hhh
 * @since 2022-05-30
 */
@Getter
@Setter
@Schema(name = "ContractStatusFlowResponse对象", description = "合同状态流转信息表")
public class ContractStatusFlowResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="合同子状态 0-草拟中 需要继续补齐")
    private Integer childStatus;

    @Schema(name="状态流转请求json记录")
    private String jsonText;

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
