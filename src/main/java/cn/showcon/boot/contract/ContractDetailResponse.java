package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 描述: 合同详情信息
 * </p>
 *
 * @author hhh
 * @since 2022/4/27
 */
@Schema(name = "合同详情所有数据信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailResponse implements Serializable {

    @Schema(name = "合同详情信息")
    private ContractInfoResponse contractInfo;
    @Schema(name = "合同要素信息")
    private List<ContractMarkInfoResponse> contractMarkInfoList;
    @Schema(name = "合同附件信息")
    private List<ContractAttachmentInfoResponse> contractAttachmentInfoList;
    @Schema(name = "合同款项计划信息")
    private List<ContractPaymentPlanResponse> contractPaymentPlanResponses;
    @Schema(name = "合同款项汇总信息")
    private List<ContractPaymentSummaryResponse> contractPaymentSummaryResponses;
    @Schema(name = "合同货物计划详情【货物信息】")
    private List<ContractCargoPlanDetailResponse> contractCargoPlanDetailResponses;
    @Schema(name = "合同货物计划")
    private List<ContractCargoPlanResponse> contractCargoPlanResponses;
    @Schema(name = "合同货物汇总")
    private List<ContractCargoSummaryResponse> contractCargoSummaryResponses;
    @Schema(name = "合同通用计划")
    private List<ContractUniversalPlanResponse> contractUniversalPlanResponses;
    @Schema(name = "合同历史状态流转")
    private List<ContractStatusFlowResponse> contractStatusFlowResponses;
    @Schema(name = "合同操作人信息")
    private ContractHandlerResponse contractHandler;
}
