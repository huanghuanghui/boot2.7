package cn.showcon.boot.web.config;


import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
public class MinioOperationDev {

    @Qualifier(value = "minioClientDev")
    @Autowired
    private MinioClient minioClient;

    private static final String BUCKET = "showconfile-dev";


    public InputStream get(String path) throws Exception {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(BUCKET)
                .object(path)
                .build();
        return minioClient.getObject(args);
    }

}
