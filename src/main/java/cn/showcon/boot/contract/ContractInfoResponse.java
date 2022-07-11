package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 合同信息表
 * </p>
 *
 * @author hhh
 * @since 2022-04-25
 */
@Getter
@Setter
@Schema(name = "ContractInfoResponse对象", description = "合同信息表")
public class ContractInfoResponse implements Serializable {
    @Schema(name="合同状态 0-草拟中 5-审批中 10-签署中 15-归档中 20-履行中")
    private String statusName;
    @Schema(name="合同子状态 0-中 需要继续补齐")
    private String childStatusName;
    @Schema(name="默认部门名称")
    private String defaultDeptName;
    @Schema(name="合同前置表ID")
    private Long preDraftId;

    //-----------------------------

    private static final long serialVersionUID = 1L;

    @Schema(name="合同合同ID")
    private Long id;

    @Schema(name="合同类型ID")
    private Long contractTypeId;

    @Schema(name="协同状态【0-未发起协同 1-已发起协同（协同中） 2-已发起协同（已锁定）】")
    private Integer cooperationStatus;

    @Schema(name="合同类型名称")
    private String contractTypeName;

    @Schema(name="合同类型全路径名称")
    private String contractTypeNamePath;

    @Schema(name="合同创建方式 0-使用合同模板 1-上传本地文件 2-使用历史合同")
    private Integer contractCreatedType;


    @Schema(name="使用合同模板创建合同模板ID")
    private Long templateId;

    @Schema(name = "历史合同ID")
    private Long historyContractId;

    @Schema(name="合同状态 0-草拟中 5-审批中 10-签署中 15-归档中 20-履行中")
    private Integer status;

    @Schema(name="合同子状态 0-草拟中 需要继续补齐")
    private Integer childStatus;

    @Schema(name="收支类型（0：无；1：收款；2：付款）")
    private Integer inOutCash;

    @Schema(name="生效时间（时间戳，年月日）")
    private Long effectiveTime;

    @Schema(name="截止时间（时间戳，年月日）")
    private Long deadline;

    @Schema(name="所属项目Id")
    private Long projectName;
    @Schema(name="盖章方式")
    private Integer stampWay;

    @Schema(name="盖章顺序")
    private Integer stampOrder;

    @Schema(name="金额")
    private BigDecimal amount;

    @Schema(name="币种")
    private String currency;

    @Schema(name="合同名称")
    private String contractName;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="签署方（相对方、签约主体）")
    private String signatory;

    @Schema(name="合同摘要")
    private String contractSummary;

    @Schema(name="是否悬浮提示，默认true，点击不在提示更新为false")
    private Boolean hoverTip;

    @Schema(name="是否作废")
    private Boolean abolished;

    @Schema(name="租户ID")
    private String tenantId;

    @Schema(name="表单版本（要素每次修改版本+1，存储合同的版本）")
    private Long contractTypeTableVersion;

    @Schema(name="草拟合同版本，每次更新版本号加一，同步到合同中心，做数据幂等与比对")
    private Integer version;

    @Schema(name="用户默认部门，用于数据权限")
    private Long defaultDeptId;

    @Schema(name="创建人id(0：系统生成,其他：账号id)")
    private Long creatorId;

    @Schema(name="创建人名称")
    private String creator;

    @Schema(name="创建时间")
    private Long createTime;


    @Schema(name="是否删除,0：未删除，时间戳：已删除")
    private Long deleted;

    @Schema(name="是否归档完成")
    private Boolean archiveComplete;

    @Schema(name = "合同表单json",required = true)
    private String jsonText;

}