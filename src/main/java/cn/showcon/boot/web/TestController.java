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


    private static final HashMap<String,String> MAP = new HashMap<>();

    static {
        MAP.put("500/6ffa0fee14d646f39b402fe2547f6e57","6ffa0fee14d646f39b402fe2547f6e57");
        MAP.put("500/c2a8f49bb2dc4ac58b55bdef93f2597b","c2a8f49bb2dc4ac58b55bdef93f2597b");
        MAP.put("500/db460610d0de48ffb61d5010cb1eebb8","db460610d0de48ffb61d5010cb1eebb8");
        MAP.put("500/a631523d05614b79bad33a2d7dc90b03","a631523d05614b79bad33a2d7dc90b03");
        MAP.put("100/70a47d5d2d554b1598d356a59f405c9b","70a47d5d2d554b1598d356a59f405c9b");
        MAP.put("100/92e10c39335c4e588d96a7335e99ab8b","92e10c39335c4e588d96a7335e99ab8b");
        MAP.put("100/03e99aa9dff649b8b04ae4d582fcaca1","03e99aa9dff649b8b04ae4d582fcaca1");
        MAP.put("100/43c98eeef3554fd7b82f26438642262a","43c98eeef3554fd7b82f26438642262a");
        MAP.put("500/5ce42732c84444cf893547e1c32c1995","5ce42732c84444cf893547e1c32c1995");
        MAP.put("500/fa1c293a26d245bb9390d28ee9de3f6f","fa1c293a26d245bb9390d28ee9de3f6f");
        MAP.put("100/4e2ca90df8c54d7badf87094787ae182","4e2ca90df8c54d7badf87094787ae182");
        MAP.put("100/67eca5a2a1b84459bd278701379a1f67","67eca5a2a1b84459bd278701379a1f67");
        MAP.put("400/da310efbb57140ec89e567e0e5f99188","da310efbb57140ec89e567e0e5f99188");
        MAP.put("400/033a945ac36749dfb18c1bba16e62476","033a945ac36749dfb18c1bba16e62476");
        MAP.put("400/a48feb6b245842b09ca4cb4e11fc9912","a48feb6b245842b09ca4cb4e11fc9912");
        MAP.put("400/7e303d3d5df34209abde308a098fc9f0","7e303d3d5df34209abde308a098fc9f0");
        MAP.put("600/f6ac5381a5c14b05bf200acc32873182","f6ac5381a5c14b05bf200acc32873182");
        MAP.put("400/d930608eb8b043ec9424d0fb4f109cd5","d930608eb8b043ec9424d0fb4f109cd5");
        MAP.put("600/8943a5b3b4b0404cb813a7e0fbc00032","8943a5b3b4b0404cb813a7e0fbc00032");
        MAP.put("400/fecbf355c8f842c6b42a49d45c736b21","fecbf355c8f842c6b42a49d45c736b21");
        MAP.put("400/849597c00ab248029ddb5448553a8c87","849597c00ab248029ddb5448553a8c87");
        MAP.put("400/81a4acdf2a7f47498b687e562886cc16","81a4acdf2a7f47498b687e562886cc16");
        MAP.put("400/1b27a19227cf4a6e87afa7b4f91c9b6d","1b27a19227cf4a6e87afa7b4f91c9b6d");
        MAP.put("400/a8d3dd7b37474f708c30e8da257ab016","a8d3dd7b37474f708c30e8da257ab016");
        MAP.put("400/3c79f712d8dc4dafbb6fc593801ce3b2","3c79f712d8dc4dafbb6fc593801ce3b2");
        MAP.put("500/43eef3d336794efea6cc231817c95ec4","43eef3d336794efea6cc231817c95ec4");
        MAP.put("500/5028349c8d3a43ffb7de7e563378ce29","5028349c8d3a43ffb7de7e563378ce29");
        MAP.put("500/facf70156a0a428ca12b13d711539b6c","facf70156a0a428ca12b13d711539b6c");
        MAP.put("500/f3a5b16b84b04bbdb14c017bd11700cb","f3a5b16b84b04bbdb14c017bd11700cb");
        MAP.put("500/8df6ef0d4a874e61bfa03bdd4eab97df","8df6ef0d4a874e61bfa03bdd4eab97df");
        MAP.put("500/41820db9eeab4079aae05dfbe9a528d1","41820db9eeab4079aae05dfbe9a528d1");
        MAP.put("600/24cf8b5f469b481da01ca52910179ae9","24cf8b5f469b481da01ca52910179ae9");
        MAP.put("600/9b2bc1ede646490f88be48f5f326ddae","9b2bc1ede646490f88be48f5f326ddae");
        MAP.put("100/01f9207f1c884592bdd96f17a1235839","01f9207f1c884592bdd96f17a1235839");
        MAP.put("100/d80279e2bcbc4f43848d6acbe5470995","d80279e2bcbc4f43848d6acbe5470995");
        MAP.put("600/287fe32eaded42448a9c9ff5968b7e32","287fe32eaded42448a9c9ff5968b7e32");
        MAP.put("600/1b0fda337ec841d4871bce640286b034","1b0fda337ec841d4871bce640286b034");
        MAP.put("100/afbdb5f4c67c47fd907a407cbb1da64f","afbdb5f4c67c47fd907a407cbb1da64f");
        MAP.put("100/4bfbc306c16945c899edb49c3692751c","4bfbc306c16945c899edb49c3692751c");
        MAP.put("100/0d6294d042ab48e79151849c4426508f","0d6294d042ab48e79151849c4426508f");
        MAP.put("600/a0b23e05a5234dfd8c8055435617245a","a0b23e05a5234dfd8c8055435617245a");
        MAP.put("100/02cb69c935d14d7999b11ad6fec77d0e","02cb69c935d14d7999b11ad6fec77d0e");
        MAP.put("400/6c4fce6114e646a3b291d67a59bcbe7e","6c4fce6114e646a3b291d67a59bcbe7e");
        MAP.put("400/92e69c9f3ab4469fbd8a889c84b1f67b","92e69c9f3ab4469fbd8a889c84b1f67b");
        MAP.put("300/1193b899e72244d28c7301d77f3ab369","1193b899e72244d28c7301d77f3ab369");
        MAP.put("400/6162d0d2ab304ef48ff984539e49e342","6162d0d2ab304ef48ff984539e49e342");
        MAP.put("100/d33e62fc1a304519af09893558a01e37","d33e62fc1a304519af09893558a01e37");
        MAP.put("400/fef92a63c6ed4f5f9d502cdeee918352","fef92a63c6ed4f5f9d502cdeee918352");
        MAP.put("400/5f5d869b68a148668c5d431bb862380b","5f5d869b68a148668c5d431bb862380b");
        MAP.put("100/a4dbd53be4ba4f2181aaf2871d291f26","a4dbd53be4ba4f2181aaf2871d291f26");
        MAP.put("100/094c8ed11c534a2d8b5a0bb3cb9718ef","094c8ed11c534a2d8b5a0bb3cb9718ef");
        MAP.put("100/fff351f4a4c243cf9e5cf6956048e8be","fff351f4a4c243cf9e5cf6956048e8be");
        MAP.put("100/1db0120054c84fd7a91e219991e888e7","1db0120054c84fd7a91e219991e888e7");
        MAP.put("100/2426c2f54aec49678672c49edad68e95","2426c2f54aec49678672c49edad68e95");
        MAP.put("100/76ffd66d9bb84946add83b35b8c97d03","76ffd66d9bb84946add83b35b8c97d03");
        MAP.put("300/b4fe2a3c863e45a99e0630a03dfecf1a","b4fe2a3c863e45a99e0630a03dfecf1a");
        MAP.put("300/da38f7dd0d4a4aba8e1cd7f8582cd0d7","da38f7dd0d4a4aba8e1cd7f8582cd0d7");
        MAP.put("300/e3457193b87e47aeb69204afe52d73c5","e3457193b87e47aeb69204afe52d73c5");
        MAP.put("300/5e716b88dd8d4e47827b7ca9024a53f0","5e716b88dd8d4e47827b7ca9024a53f0");
        MAP.put("400/1807305ade9849a69d5260167f8494a2","1807305ade9849a69d5260167f8494a2");
        MAP.put("300/8396231055324b518234fc30fd0607a8","8396231055324b518234fc30fd0607a8");
        MAP.put("300/f1bdf503e096454ab1e834c0c44a49c9","f1bdf503e096454ab1e834c0c44a49c9");
        MAP.put("300/2fc49d153e7042c29bccf4e283570b16","2fc49d153e7042c29bccf4e283570b16");
        MAP.put("300/4ac02d082bfa4f48ae4d59bb78e6745e","4ac02d082bfa4f48ae4d59bb78e6745e");
        MAP.put("300/dae74b7205074b52a39980ff8d9da7e3","dae74b7205074b52a39980ff8d9da7e3");
        MAP.put("300/34ea1a619da649ec8182be822ec7dd8d","34ea1a619da649ec8182be822ec7dd8d");
        MAP.put("400/70bfad1cf729498e83b4c74e6f8a350e","70bfad1cf729498e83b4c74e6f8a350e");
        MAP.put("400/3d399b82b81a4ea8af39e656e4cb6590","3d399b82b81a4ea8af39e656e4cb6590");
        MAP.put("300/5aaa6b7be6e54ec4b85274208e45ca7c","5aaa6b7be6e54ec4b85274208e45ca7c");
        MAP.put("100/a1a463137acc45d9a91247cf46cf0f3b","a1a463137acc45d9a91247cf46cf0f3b");
        MAP.put("100/67d42abfe6854ffb84e8b81b00069f8d","67d42abfe6854ffb84e8b81b00069f8d");
        MAP.put("400/d80128abf23d476c802cac57261ebac2","d80128abf23d476c802cac57261ebac2");
        MAP.put("400/097c8a01b86944209a41832eba7c5800","097c8a01b86944209a41832eba7c5800");
        MAP.put("400/accef3414405405a9b35f094d5ff3818","accef3414405405a9b35f094d5ff3818");
        MAP.put("400/e90a0626769f4f3e93bba0b77a2805c5","e90a0626769f4f3e93bba0b77a2805c5");
        MAP.put("400/a0d8f6ba58af4d8bb2d334a57fa15f5c","a0d8f6ba58af4d8bb2d334a57fa15f5c");
        MAP.put("400/ee2ae0478cd542c7853758910c06110b","ee2ae0478cd542c7853758910c06110b");
        MAP.put("400/048a046f215e4e02a1ccac8bb09eb995","048a046f215e4e02a1ccac8bb09eb995");
        MAP.put("400/3365f54f89184b4cb934de1633b6bdb8","3365f54f89184b4cb934de1633b6bdb8");
        MAP.put("400/ba36673a81fa4c9593aaa61638ab75d9","ba36673a81fa4c9593aaa61638ab75d9");
        MAP.put("400/b5247f6807914ce8b9df88114f5ec5b0","b5247f6807914ce8b9df88114f5ec5b0");
        MAP.put("400/6f6dcef6033b4a2c9ba8d68ef0235e6a","6f6dcef6033b4a2c9ba8d68ef0235e6a");
        MAP.put("400/4cb801e930154e9aaebe481aea267f7c","4cb801e930154e9aaebe481aea267f7c");
        MAP.put("300/da308c93d24445f2aa57d91698cae1ee","da308c93d24445f2aa57d91698cae1ee");
        MAP.put("300/faba74a98be344d3b75662f8dd07f786","faba74a98be344d3b75662f8dd07f786");
        MAP.put("300/dbbfba8fc05349ba92d4ccf12659add9","dbbfba8fc05349ba92d4ccf12659add9");
        MAP.put("300/68bbb82e4b18400f9953f47ae5dba569","68bbb82e4b18400f9953f47ae5dba569");
        MAP.put("300/79a02ba7930847ca8b436ee4bbf7edab","79a02ba7930847ca8b436ee4bbf7edab");
        MAP.put("300/a047171137924686bf22c64e13aad66e","a047171137924686bf22c64e13aad66e");
        MAP.put("300/1ae1973fe54149c6a35004d29f4dd162","1ae1973fe54149c6a35004d29f4dd162");
        MAP.put("400/595a4661f4c147e09bbb9cfd052baade","595a4661f4c147e09bbb9cfd052baade");
        MAP.put("400/225376f70b9b49c6999831779e921124","225376f70b9b49c6999831779e921124");
        MAP.put("400/20742dee18894ff59fbdf2bad28af64f","20742dee18894ff59fbdf2bad28af64f");
        MAP.put("100/d7c62317ea54434cb0fe5eca492836b2","d7c62317ea54434cb0fe5eca492836b2");
        MAP.put("400/074d2ed2ddeb43b6aca0b72086ace2d5","074d2ed2ddeb43b6aca0b72086ace2d5");
        MAP.put("100/8f6181185b91430c8de35f376b26b83a","8f6181185b91430c8de35f376b26b83a");
        MAP.put("100/0faf996213c74bf4b74a471e22768838","0faf996213c74bf4b74a471e22768838");
        MAP.put("400/5e4e3d32fb4a4a398d6ae037ce38ebc8","5e4e3d32fb4a4a398d6ae037ce38ebc8");
        MAP.put("400/1e356b7e83194760b1b3dd2827115d1b","1e356b7e83194760b1b3dd2827115d1b");
        MAP.put("400/a9c97c3c87034b7f8dad05b54a052445","a9c97c3c87034b7f8dad05b54a052445");
        MAP.put("400/64d4405a3af846b5b939a9baa3c78e89","64d4405a3af846b5b939a9baa3c78e89");
        MAP.put("400/494f7630f70144b584d0cf7535fe6cd0","494f7630f70144b584d0cf7535fe6cd0");
        MAP.put("100/bf1cee14edfa42eabedffb1dec20dd9c","bf1cee14edfa42eabedffb1dec20dd9c");
        MAP.put("100/f4df2f60f2004885badf1c6ac6acd359","f4df2f60f2004885badf1c6ac6acd359");
        MAP.put("100/ef3b2a9721a64e7e8e489d4572f56f08","ef3b2a9721a64e7e8e489d4572f56f08");
        MAP.put("100/bf5189daba4d4f92addeea9595ff3cff","bf5189daba4d4f92addeea9595ff3cff");
        MAP.put("300/13ff9aed107a48a8ae82c0960b302560","13ff9aed107a48a8ae82c0960b302560");
        MAP.put("400/536e94e692b5438ebca47e09341581e1","536e94e692b5438ebca47e09341581e1");
        MAP.put("400/4ec8537aece447f2bdb786418371c8ca","4ec8537aece447f2bdb786418371c8ca");
        MAP.put("400/daa1501716e945578e1d6d813ea91d49","daa1501716e945578e1d6d813ea91d49");
        MAP.put("400/c3d304d307884f0db9d1c6fffb8134b2","c3d304d307884f0db9d1c6fffb8134b2");
        MAP.put("400/e3aa55ef25dd412dba0ed792e11c575b","e3aa55ef25dd412dba0ed792e11c575b");
        MAP.put("400/aa623d6473ec4e1f90b22e2cc53bb9b0","aa623d6473ec4e1f90b22e2cc53bb9b0");
        MAP.put("400/c655ca878195493fa7f9506dad7b04fa","c655ca878195493fa7f9506dad7b04fa");
        MAP.put("400/24eec4d2352e4f16adee1af6af773359","24eec4d2352e4f16adee1af6af773359");
        MAP.put("400/faa94c58ed1f496f8b7a0e56bc563abf","faa94c58ed1f496f8b7a0e56bc563abf");
        MAP.put("100/50916164edc54bd68417fc23a2763b6e","50916164edc54bd68417fc23a2763b6e");
        MAP.put("100/7843e46e88a34c1a98d2836300589e5a","7843e46e88a34c1a98d2836300589e5a");
        MAP.put("400/d6fc06f2603d4981a736a87b42b7ecde","d6fc06f2603d4981a736a87b42b7ecde");
        MAP.put("100/c56b73a102684344a9fec820f1350b91","c56b73a102684344a9fec820f1350b91");
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
