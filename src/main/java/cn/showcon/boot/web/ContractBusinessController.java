package cn.showcon.boot.web;

import cn.showcon.boot.config.DbProperties;
import cn.showcon.boot.config.PageRequest;
import cn.showcon.boot.contract.ContractDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 合同信息表 审批前端控制器
 * </p>
 *
 * @author hhh
 * @since 2022-05-04
 */
@RestController
@RequestMapping("/api/v1/contract/sign")
@Tag(name = "合同中心相关服务")
public class ContractBusinessController {


    @Autowired
    private DbProperties dbProperties;
    @Operation(summary = "查询合同快照信息2")
    @GetMapping("/snapshot2")
    public String getContractSnapshot(PageRequest pageRequest) {
        return dbProperties.getName();
    }

}
