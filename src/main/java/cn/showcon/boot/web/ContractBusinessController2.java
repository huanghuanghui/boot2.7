package cn.showcon.boot.web;

import cn.showcon.boot.config.CLMUserDetails;
import cn.showcon.boot.contract.ContractDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 合同信息表 审批前端控制器
 * </p>
 *
 * @author hhh
 * @since 2022-05-04
 */
@RestController
@RequestMapping("/innerapi/v1/contract/sign")
@Tag(name = "合同中心相关服务-innerapi")
public class ContractBusinessController2 implements ApplicationContextAware {

    private AnnotationConfigServletWebServerApplicationContext springApplication;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springApplication=(AnnotationConfigServletWebServerApplicationContext)applicationContext;
    }

    @Operation(summary = "查询合同详情")
    @GetMapping("/refresh")
    public ContractDetailResponse getContract(@Parameter(name ="合同编码",required = true) String contractCode,
                                              @Parameter(hidden = true) CLMUserDetails userDetails) {
        springApplication.refresh();
        return null;
    }

    @Operation(summary = "查询合同快照信息")
    @GetMapping("/snapshot")
    public String getContractSnapshot(@Parameter(name = "快照ID", required = true, example = "0") @RequestParam @NotBlank(message = "请选择需要查询的快照ID") Long snapshotId) {
        return "查询合同快照信息";
    }


}
