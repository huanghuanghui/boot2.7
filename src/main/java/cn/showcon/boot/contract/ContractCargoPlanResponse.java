package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 合同货物计划
 * </p>
 *
 * @author hhh
 * @since 2022-05-17
 */
@Getter
@Setter
@Schema(name = "ContractCargoPlan对象", description = "合同货物计划")
public class ContractCargoPlanResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="id")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="货物计划名称")
    private String cargoPlanName;

    @Schema(name="相对方企业ID")
    private Long oppositeEnterpriseId;

    @Schema(name="相对方企业名称")
    private String oppositeEnterpriseName;

    @Schema(name="交付方向 0-交货 1-收货【控制单据的交/付，汇总中有就选择汇总数据，无则新增一条数据到汇总数据中】")
    private Integer deliverDirection;

    @Schema(name="截止时间")
    private Long deadline;

    @Schema(name="交付方式 0-原库划转 1-供方自提 2-需方包到")
    private Integer deliverType;

    @Schema(name="仓库地址")
    private String storehouseAddress;

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
