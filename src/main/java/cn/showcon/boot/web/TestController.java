package cn.showcon.boot.web;

import cn.showcon.boot.web.config.MinioOperationDemo;
import cn.showcon.boot.web.config.MinioOperationDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class TestController {

    @Autowired
    private MinioOperationDev minioOperationDev;
    @Autowired
    private MinioOperationDemo minioOperationDemo;

    private static String FILE_TO = "/Users/hhh/workspace/code/study/boot2.7/file/";

    @GetMapping("/upload")
    public void getContractSnapshot(String path,String fileName)throws Exception {
        InputStream inputStream = minioOperationDev.get(path);
        File file = new File(FILE_TO+fileName);
        copyInputStreamToFile(inputStream, file);
        File newfile = new File(FILE_TO+fileName);
        InputStream inputStreamTo = new FileInputStream(newfile);
        minioOperationDemo.upload(path,inputStreamTo);
    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}
