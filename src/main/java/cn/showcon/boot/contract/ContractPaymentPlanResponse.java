package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 收付款计划
 * </p>
 *
 * @author hhh
 * @since 2022-05-13
 */
@Getter
@Setter
@Schema(name = "ContractPaymentPlanResponse对象", description = "收付款计划")
public class ContractPaymentPlanResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="计划名称【收款计划1/付款计划2叠加】")
    private String planName;

    @Schema(name="金额【收款/付款金额】")
    private BigDecimal planAmount;

    @Schema(name="相对方企业ID【收/付款方】")
    private Long oppositeEnterpriseId;

    @Schema(name="相对方企业名称【收/付款方】")
    private String oppositeEnterpriseName;

    @Schema(name="我方企业ID【收/付款方】")
    private Long ourEnterpriseId;

    @Schema(name="我方企业名称【收/付款方】")
    private String ourEnterpriseName;

    @Schema(name="截止时间")
    private Long deadline;

    @Schema(name="发票类型 0-普票 1-专票")
    private Integer billType;

    @Schema(name="税率【前端填写，后端存小数，需要前端转换，例如10%传0.1，后续计算使用】")
    private BigDecimal taxRate;

    @Schema(name="发票形态 0-电子发票 1-纸质发票")
    private String billForm;

    @Schema(name="备注")
    private String remark;

    @Schema(name="接收邮箱")
    private String email;

    @Schema(name="合同收款汇总类型 0-收款 1-付款")
    private Integer type;

    @Schema(name="税后金额【后端计算，金融*（1-税率）】")
    private BigDecimal planEstimatedAfterTaxAmount;

    @Schema(name="税额【后端计算，金额*税率】")
    private BigDecimal planEstimatedTax;

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
