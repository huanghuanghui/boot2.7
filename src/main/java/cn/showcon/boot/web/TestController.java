package cn.showcon.boot.web;

import cn.showcon.boot.web.config.MinioOperationDev;
import io.minio.GetObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MinioOperationDev minioOperationDev;

    /**
     * 需要同步的文件path，key为路径，value为文件ID
     */
    private static final HashMap<String,String> MAP = new HashMap<>();

    static {
        MAP.put("600/c8b082e9044a49e38c4afedaa8467b73","c8b082e9044a49e38c4afedaa8467b73");
    }


    public static void main(String[] args) {
        for (Map.Entry<String, String> stringStringEntry : MAP.entrySet()) {
            System.out.println(stringStringEntry.getKey()+"="+stringStringEntry.getValue());
        }
    }


    @GetMapping("/upload")
    public void upload()throws Exception{
        for (Map.Entry<String, String> stringStringEntry : MAP.entrySet()) {
            OutputStream outStream = null;
            GetObjectResponse getObjectResponse = null;
            try {
                String minioPath = stringStringEntry.getKey();
                String tenantId = getTenantId(minioPath);
                String ossKey = stringStringEntry.getValue();
                String ossPath =  "/Users/hhh/workspace/code/study/boot2.7/file/"+tenantId+"/"+ossKey;
                File targetFile = new File(ossPath);
                getObjectResponse =minioOperationDev.get(minioPath);
                outStream = new FileOutputStream(targetFile);
                InputStream file = cloneInputStream(getObjectResponse);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = file.read(buffer)) > 0) {
                    outStream.write(buffer, 0, len);
                }
                log.info("成功写入文件-{}",ossPath);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (outStream!=null){
                    outStream.close();
                }
                if (getObjectResponse!=null){
                    getObjectResponse.close();
                }
            }
        }
    }

    private  static  String getTenantId(String minioPath){
        String tenantId = "100";
        if (minioPath.startsWith("200")){
            tenantId="200";
        }
        if (minioPath.startsWith("300")){
            tenantId="300";
        }
        if (minioPath.startsWith("400")){
            tenantId="400";
        }
        if (minioPath.startsWith("500")){
            tenantId="500";
        }
        if (minioPath.startsWith("600")){
            tenantId="600";
        }
        return tenantId;
    }

    private static InputStream cloneInputStream(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
