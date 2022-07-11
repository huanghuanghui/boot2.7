package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 书签记录
 * </p>
 *
 * @author hhh
 * @since 2022-04-26
 */
@Getter
@Setter
@Schema(name = "ContractMarkInfoResponse对象", description = "书签记录")
public class ContractMarkInfoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="要素类型 0-表单要素 1-合同条款")
    private Integer type;


    @Schema(name="默认条款")
    private String defaultContent;

    @Schema(name="条款库ID(新增条款选择从条款库选择模版ID必传,查看与编辑的时候需要选中已经选择的条款)")
    private Long templateId;

    @Schema(name="字段（书签）名称，例如：{\"fieldName\": \"deadline\",\"fieldText\": \"截止时间\",\"fieldValue\": \"20220101\"}")
    private String fieldName;

    @Schema(name="关联字段（书签）文本")
    private String fieldText;

    @Schema(name="关联字段（书签）文本值")
    private String fieldValue;

    @Schema(name="关联字段类别")
    private Integer category;

    @Schema(name="使用说明")
    private String remark;

    @Schema(name="是否为自定义要素（除了元素配置外，其他全是自定义要素）默认非自定义要素")
    private Boolean customMark;


    @Schema(name="是否必填（false：否；true：是）")
    private Boolean required;

    @Schema(name="输入类型（1：text；2：select；3：radio；4：checkbox；5：date；6：select_multiple；7：long_text;8:table;9:int;a:float;b:cascader(级联单选);c:cascader_multiple(级联多选)）")
    private String inputType;

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

    @Schema(name="子表数据")
    private List<List<TableValue>> tableValues;

    @Schema(name="要素关联书签信息")
    private List<ContractMarkLinkResponse> contractMarkLinkResponses;


}
