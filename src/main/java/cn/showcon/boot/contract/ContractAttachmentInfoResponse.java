package cn.showcon.boot.contract;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 合同附件
 * </p>
 *
 * @author hhh
 * @since 2022-04-25
 */
@Getter
@Setter
@Schema(name = "ContractAttachmentInfoResponse", description = "合同附件")
public class ContractAttachmentInfoResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(name="ID")
    private Long id;

    @Schema(name="合同编号")
    private String contractCode;

    @Schema(name="文件ID")
    private String fileId;

    @Schema(name="文件名称")
    private String fileName;

    @Schema(name="文件类型 0-正文 1-其他附件 2-通用附件")
    private Integer fileType;

    @Schema(name="文件是否需要签署，发起签署中选择需要签署的文件")
    private Boolean needSign;

    @Schema(name="源文件ID（清稿后的源文件）")
    private String srcFileId;

    @Schema(name="是否清稿（清稿后，源文件存在src_file_id）")
    private Boolean cleanCopy;

    @Schema(name="文件密码(冰蓝服务需要文件密码)")
    private String filePassword;

    @Schema(name="是否允许删除该附件（默认true，允许删除，例如草拟使用模板中的附件/合同正文不能删除）")
    private Boolean allowDeleted;

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
