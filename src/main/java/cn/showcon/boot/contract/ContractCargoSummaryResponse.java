package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 合同货物汇总
 * </p>
 *
 * @author hhh
 * @since 2022-05-17
 */
@Getter
@Setter
@Schema(name = "ContractCargoSummary对象", description = "合同货物汇总")
public class ContractCargoSummaryResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(name="id")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="统一编号")
    private String unifiedNumber;

    @Schema(name="品名")
    private String productName;

    @Schema(name="厂家品牌")
    private String brand;

    @Schema(name="参数规格")
    private String standard;

    @Schema(name="单位")
    private String unit;

    @Schema(name="合同交付类型0-交货 1-收货")
    private Integer contractDeliverDirection;

    @Schema(name="合同交付数量")
    private BigDecimal contractDeliverAmount;

    @Schema(name="计划交付数量【交货计划数值相加】")
    private BigDecimal planDeliverAmount;

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
