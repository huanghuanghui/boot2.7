package cn.showcon.boot.web;

import cn.showcon.boot.web.config.MinioOperationDemo;
import cn.showcon.boot.web.config.MinioOperationDev;
import io.minio.GetObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MinioOperationDev minioOperationDev;
    @Autowired
    private MinioOperationDemo minioOperationDemo;


    private static final Set<String> SET = new HashSet<>();

    static {
        SET.add("500/8cf8fc6449c14e9ea6626c030cdd10ca");
        SET.add("500/c29b7e352e0343aa9a8c2eb1906862f6");
        SET.add("500/d3bffad77b7f474088109923bbe5aed6");
        SET.add("500/80d13103fba040a5a5848106af52cbf0");
        SET.add("500/d683a1de0b9444109fba5da7a315090b");
        SET.add("500/4bdcf3006c08493888e11dba9ec52b27");
        SET.add("500/bd30ab31b433405bab34960ed6842e7a");
        SET.add("500/0d01d1126a3649aa8ead08cd3ebcbdda");
        SET.add("500/b6e973d90b664799af8aadcc74822101");
        SET.add("500/82caed0630ff4a0ea7d88ba94364efe3");
        SET.add("500/de0479c7cf3244d2bb64fe4d3600474a");
        SET.add("500/93413de090664edf92cd5d16a548c211");
        SET.add("500/2cee56efb0e54fc0a107334f1c42314e");
        SET.add("500/207b6a2534f64442895ede2ab4346154");
        SET.add("500/3005fef3142c41ca9315ceae6a9deb09");
        SET.add("500/ad7f9921bf184290adc83773744e371f");
        SET.add("500/9c88a0149b7d4fac9d31eb33ffec65e4");
        SET.add("500/6c85107ddedb4a278f7d82f3f7504148");
        SET.add("500/000283de1b0f4ea0af48aba94aedebf2");
        SET.add("500/de349342215c49c9bb036dbc09412f0a");
        SET.add("500/5be35b9a14c34f3f90b06818839ddff8");
        SET.add("500/3757cf846b9d408ead5351ff1d997a38");
        SET.add("500/1757c60260014c42aad6f57aa8f9665b");
        SET.add("500/c627c6abc4f44acb97c5ab78b02dce00");
        SET.add("500/7b81c7d0d21e43f88f6abd8f181dfcba");
        SET.add("500/d83afa93923a4dce9da6bbc1aacb5e3f");
        SET.add("500/d1d321db24b5425aacb930863cea7bd7");
        SET.add("500/103af2e725954b1ba9b2aaf9fe7853fc");
        SET.add("500/711f9a6f62814422ba8924f06f7d57e3");
        SET.add("500/2c951c0252a844be95c21a6b78e365e1");
        SET.add("500/d355554536c847b08a160310b003aa49");
        SET.add("500/266454aea2534d95ae9d79200f097d82");
        SET.add("500/9621a92ebd1a40eabcb23bff28b699cd");
        SET.add("500/b7a27ab2eeb8424992d07ec42f8a2ac0");
        SET.add("500/0892281752b3420d8f75f9fc85af1707");
        SET.add("500/d78fe5ab6fb846e2841bd5864a12c842");
        SET.add("500/1e9eb755ca03424bb009bae9ba3c68c8");
        SET.add("500/83b8c2b73cce4be997bb618071ec9a6e");
        SET.add("500/4ed75d191eed47719de45e7be552a1bf");
        SET.add("300/d8b23cc3762d400d951ac9579ba949c3");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
        SET.add("");
    }


    @GetMapping("/upload")
    public void getContractSnapshot()throws Exception {
        for (String path : SET) {
            GetObjectResponse getObjectResponse =minioOperationDev.get(path);
            minioOperationDemo.upload(path,cloneInputStream(getObjectResponse));
            log.info("文件上传完成-{}",path);
        }
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
