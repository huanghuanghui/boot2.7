package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 收付款计划汇总
 * </p>
 *
 * @author hhh
 * @since 2022-05-13
 */
@Getter
@Setter
@Schema(name = "ContractPaymentSummaryResponse对象", description = "收付款计划汇总")
public class ContractPaymentSummaryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="计划汇总【添加的款项收付款相加】")
    private BigDecimal planAmountSummary;

    @Schema(name="计划汇总预估税后金额【添加的款项收付款税后金额相加】")
    private BigDecimal planEstimatedAfterTaxAmount;

    @Schema(name="计划汇总预估税额【前端填写，后端存小数，需要前端转换，例如10%传0.1，后续计算使用】")
    private BigDecimal planEstimatedTax;

    @Schema(name="合同汇总【收款-收款计划汇总/付款-付款计划汇总】")
    private BigDecimal contractAmountSummary;

    @Schema(name="合同汇总预估税后金额【后端计算，计划汇总*（1-预估税率）】")
    private BigDecimal contractEstimatedAfterTaxAmount;

    @Schema(name="合同汇总,预估税额【添加的款项收付款税额相加】")
    private BigDecimal contractEstimatedTax;

    @Schema(name="合同汇总汇总预估税率【后端计算，计划汇总*预估税率】")
    private BigDecimal contractEstimatedTaxRate;

    @Schema(name="合同收款汇总类型 0-收款 1-付款")
    private Integer type;

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
