package cn.showcon.boot.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/6/28
 */
@Configuration
public class DocConfig {


    String appName = "draft";
    String version = "1.0";
    private static final String WEB_API = "1.Web-Api";
    private static final String SC_Access_Token = "SC_Access_Token";
    private static final String SC_Id_Token = "SC_Id_Token";
    private static final String INNER_API = "2.Inner-Api";
    private static final String OPEN_API = "3.Open-Api";

    @Autowired
    private GlobalHeaderOperationCustomizer globalHeaderOperationCustomizer;


    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group(WEB_API)
                .pathsToMatch("/api/v*/**")
                .packagesToScan("cn.showcon")
                .displayName(WEB_API)
                .addOperationCustomizer(globalHeaderOperationCustomizer)
                .build();
    }


    @Bean
    public GroupedOpenApi innerApi() {
        return GroupedOpenApi.builder()
                .group(INNER_API)
                .pathsToMatch("/innerapi/v*/**")
                .packagesToScan("cn.showcon")
                .displayName(INNER_API)
                .build();
    }


    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder()
                .group(OPEN_API)
                .pathsToMatch("/openapi/v*/**")
                .packagesToScan("cn.showcon")
                .displayName(OPEN_API)
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Components components = new Components();
        components.addSecuritySchemes(SC_Access_Token, new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name(SC_Access_Token));
        components.addSecuritySchemes(SC_Id_Token, new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name(SC_Id_Token));
        return new OpenAPI()
                .info(new Info().title(appName).version(version))
                .components(components)
                .addSecurityItem(new SecurityRequirement().addList(SC_Access_Token).addList(SC_Id_Token));
    }
}
