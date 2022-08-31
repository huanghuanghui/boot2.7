package cn.showcon.boot.web.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration1 {


    @Bean(name = "minioClientDev")
    public MinioClient minioClient(){

        MinioClient minioClient=MinioClient.builder()
                .endpoint("http://xxx:9000")
                .credentials("admin", "123456789")
                .build();
        return minioClient;
    }

}
