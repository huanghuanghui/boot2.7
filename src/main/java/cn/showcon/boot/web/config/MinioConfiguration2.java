package cn.showcon.boot.web.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration2 {


    @Bean(name = "minioClientDemo")
    public MinioClient minioClient(){
        MinioClient minioClient=MinioClient.builder()
                .endpoint("http://ip:port")
                .credentials("admin", "123456789")
                .build();
        return minioClient;
    }

}
