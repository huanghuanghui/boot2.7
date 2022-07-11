package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 合同通用计划
 * </p>
 *
 * @author hhh
 * @since 2022-05-13
 */
@Getter
@Setter
@Schema(name = "ContractUniversalPlanResponse对象", description = "合同通用计划")
public class ContractUniversalPlanResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="计划名称【通用计划1/通用计划2叠加】")
    private String universalPlanName;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="截止时间")
    private Long deadline;

    @Schema(name="备注")
    private String remark;

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
