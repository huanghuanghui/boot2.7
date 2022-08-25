package cn.showcon.boot.web.config;


import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
public class MinioOperationDemo {

    @Qualifier(value = "minioClientDemo")
    @Autowired
    private MinioClient minioClient;

    private static final String BUCKET = "hhh-test";

    public void upload(String path, InputStream file) throws Exception {
        long partSize = -1;
        if (file.available() >= 50 * 1024 * 1024) {
            partSize = 50 * 1024 * 1024;
        }
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(BUCKET)
                .object(path)
                .stream(file, file.available(), partSize)
                .build());
    }


}
