package cn.showcon.boot.config;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SwaggerPageable {

    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "size"
            , schema = @Schema(type = "integer", defaultValue = "10"))

    private int size;
    @Parameter(in = ParameterIn.QUERY
            , description = "Zero-based page index (1..N)"
            , name = "page"
            , schema = @Schema(type = "integer", defaultValue = "1"))
    private int page;
    @Parameter(in = ParameterIn.QUERY
            , description = "Sorting criteria in the format: property,(asc|desc). "
            + "Default sort order is ascending. " + "Multiple sort criteria are supported."
            , name = "sort"
            , schema = @Schema(type = "string", defaultValue = ""))
    private String sort;
}
