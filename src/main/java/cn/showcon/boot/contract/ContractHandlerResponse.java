package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 合同操作人表（合同表垂直扩展表存储操作用户信息）
 * </p>
 *
 * @author hhh
 * @since 2022-06-08
 */
@Getter
@Setter
@Schema(name = "ContractHandlerResponse对象", description = "合同操作人表（合同表垂直扩展表存储操作用户信息）")
public class ContractHandlerResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="审批拒绝人ID")
    private Long approveRejectHandlerId;

    @Schema(name="审批拒绝人名称")
    private String approveRejectHandler;

    @Schema(name="审批拒绝原因")
    private String approveRejectReason;

    @Schema(name="审批拒绝时间")
    private Long approveRejectDate;

    @Schema(name="签署拒绝人ID")
    private Long signRejectHandlerId;

    @Schema(name="签署拒绝人名称")
    private String signRejectHandler;

    @Schema(name="签署拒绝原因")
    private String signRejectReason;

    @Schema(name="签署拒绝时间")
    private Long signRejectDate;

    @Schema(name="审批撤回备注")
    private String revertApprovalRemark;

    @Schema(name="审批撤回时间")
    private Long revertApprovalDate;

    @Schema(name="作废备注")
    private String abolishedRemark;

    @Schema(name="作废时间")
    private Long abolishedDate;

    @Schema(name="签署撤回备注")
    private String signRevertRemark;

    @Schema(name="签署撤回时间")
    private Long signRevertDate;

    @Schema(name="签署完成时间")
    private Long signedTime;

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
