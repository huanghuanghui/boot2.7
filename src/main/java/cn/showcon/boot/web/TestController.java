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
        MAP.put("600/c8b082e9044a49e38c4afedaa8467b73","c8b082e9044a49e38c4afedaa8467b73");
        MAP.put("100/23cb1281c73d426890784781b8594bca","23cb1281c73d426890784781b8594bca");
        MAP.put("400/ef1016b4b7a242489bac9950e7ad02ad","ef1016b4b7a242489bac9950e7ad02ad");
        MAP.put("100/c854b1b54e874fb88ecc2efe17866e3b","c854b1b54e874fb88ecc2efe17866e3b");
        MAP.put("600/2f336c34f984495b998099ee7d3c43cd","2f336c34f984495b998099ee7d3c43cd");
        MAP.put("600/6aaffdcbe20946deb071f7a472af0c51","6aaffdcbe20946deb071f7a472af0c51");
        MAP.put("400/ac7d7788f59b4cc181ceabd0b2abe812","ac7d7788f59b4cc181ceabd0b2abe812");
        MAP.put("400/07347a8fddc340b3a916e117d97a089b","07347a8fddc340b3a916e117d97a089b");
        MAP.put("400/5e075180973b46c491bbd8a2c33b0256","5e075180973b46c491bbd8a2c33b0256");
        MAP.put("100/112697d1317e4c2ebbd95691c6ff1869","112697d1317e4c2ebbd95691c6ff1869");
        MAP.put("100/9da4fef545784177ac5b1fc96b58b7c6","9da4fef545784177ac5b1fc96b58b7c6");
        MAP.put("400/dcb2fcbef99d4fe88f111a33a0b15724","dcb2fcbef99d4fe88f111a33a0b15724");
        MAP.put("400/4f40c778ce6843c9a59b855f51b617e7","4f40c778ce6843c9a59b855f51b617e7");
        MAP.put("100/3444687c21364112b3ed360fb9feebe4","3444687c21364112b3ed360fb9feebe4");
        MAP.put("600/1303529edefd495eacc58a732840624a","1303529edefd495eacc58a732840624a");
        MAP.put("100/4112df2bf3134a29bfeec59261ec03c7","4112df2bf3134a29bfeec59261ec03c7");
        MAP.put("400/f4430e38ccba4cb2856030cd4e195b70","f4430e38ccba4cb2856030cd4e195b70");
        MAP.put("100/70d22b6b846042e5a4b7262d9efdfac3","70d22b6b846042e5a4b7262d9efdfac3");
        MAP.put("300/9fe0181f418140a19becf1ccdc1bdb5a","9fe0181f418140a19becf1ccdc1bdb5a");
        MAP.put("600/758cc69a59ba40b7a5ee5a4e4825759c","758cc69a59ba40b7a5ee5a4e4825759c");
        MAP.put("200/b5246f776e0549ffa790f56e8d7c9cea","b5246f776e0549ffa790f56e8d7c9cea");
        MAP.put("400/213727de43dc4d06a18fc4d64b1ec135","213727de43dc4d06a18fc4d64b1ec135");
        MAP.put("500/d0f0a1bceeeb4cc0a4e126c94a016a47","d0f0a1bceeeb4cc0a4e126c94a016a47");
        MAP.put("600/748a3abd17fe4b6eb588a9c9448456b8","748a3abd17fe4b6eb588a9c9448456b8");
        MAP.put("600/f250668a5b1a4445b83f661984223f73","f250668a5b1a4445b83f661984223f73");
        MAP.put("400/9ba96380a9384583a530ebac0d96aea0","9ba96380a9384583a530ebac0d96aea0");
        MAP.put("400/5f3b0963a078442bb66ecfddbb141d20","5f3b0963a078442bb66ecfddbb141d20");
        MAP.put("400/fbb19a192b634727b73af9255020d019","fbb19a192b634727b73af9255020d019");
        MAP.put("400/71c24943b1ec4ab3ac3d05e4464e8922","71c24943b1ec4ab3ac3d05e4464e8922");
        MAP.put("100/c268385f7e6c48609f24fa663cfaa3f9","c268385f7e6c48609f24fa663cfaa3f9");
        MAP.put("400/de8994d550bb427bbb22c407dd18a9cb","de8994d550bb427bbb22c407dd18a9cb");
        MAP.put("400/c68dd95c2da241fb8eeff45756934000","c68dd95c2da241fb8eeff45756934000");
        MAP.put("300/f41b87fe5e1648e9a86b1bbf8aa7e8a4","f41b87fe5e1648e9a86b1bbf8aa7e8a4");
        MAP.put("400/02c02c760f5441f1b8293d2304b939c5","02c02c760f5441f1b8293d2304b939c5");
        MAP.put("600/7b19ad463e354a05bf517571580b178f","7b19ad463e354a05bf517571580b178f");
        MAP.put("100/2d3e1bb5ef1b403c8d2b3bbc834b08fc","2d3e1bb5ef1b403c8d2b3bbc834b08fc");
        MAP.put("100/0274541d1e6448de87eafd6633217434","0274541d1e6448de87eafd6633217434");
        MAP.put("500/c56c025a50d7490aa85437d1fbc1164c","c56c025a50d7490aa85437d1fbc1164c");
        MAP.put("300/01a33ce64c64450198ad9bcebcce1148","01a33ce64c64450198ad9bcebcce1148");
        MAP.put("300/f313c269f0a3413392e10e4efde29e9e","f313c269f0a3413392e10e4efde29e9e");
        MAP.put("100/fcf00431b39f43fdb08a248a6d43f9a0","fcf00431b39f43fdb08a248a6d43f9a0");
        MAP.put("500/46e8c8e07cf04873bb990426e3185a85","46e8c8e07cf04873bb990426e3185a85");
        MAP.put("400/7c087dc67d724d518e12a4ae71707f7e","7c087dc67d724d518e12a4ae71707f7e");
        MAP.put("100/f05fd5e874b0498e9f5ba53f7595dfe3","f05fd5e874b0498e9f5ba53f7595dfe3");
        MAP.put("300/ef4eb0829cc3460bb47ed6237a718fb6","ef4eb0829cc3460bb47ed6237a718fb6");
        MAP.put("100/cbb396344e2d44e0bb845ab8b9bd7858","cbb396344e2d44e0bb845ab8b9bd7858");
        MAP.put("300/4c0b1fb47aa54774aa495b29b6113c44","4c0b1fb47aa54774aa495b29b6113c44");
        MAP.put("100/30831d781f0a4d52bf9ae974a657bbd7","30831d781f0a4d52bf9ae974a657bbd7");
        MAP.put("600/8217ca0817a14926b868bf7f4e2cb7fa","8217ca0817a14926b868bf7f4e2cb7fa");
        MAP.put("500/147379b0b0774bbbadfdf49266a3c176","147379b0b0774bbbadfdf49266a3c176");
        MAP.put("600/e0a8863eed5146c18da13b9711a82561","e0a8863eed5146c18da13b9711a82561");
        MAP.put("500/d271ec291e9248609b43f9b5e2f66183","d271ec291e9248609b43f9b5e2f66183");
        MAP.put("600/782b7e3f04544a2a91b9e0dc0c4cac51","782b7e3f04544a2a91b9e0dc0c4cac51");
        MAP.put("400/5f82d304c80f416ba1a1f7519e41b4f0","5f82d304c80f416ba1a1f7519e41b4f0");
        MAP.put("200/6c9aa9b010b74fc78f578ab48f676847","6c9aa9b010b74fc78f578ab48f676847");
        MAP.put("300/6cf2a61109cc4b2ea48e39ab9bcf13cc","6cf2a61109cc4b2ea48e39ab9bcf13cc");
        MAP.put("600/ecabd0318d0f47d080067bd754b512a8","ecabd0318d0f47d080067bd754b512a8");
        MAP.put("500/07569c63e2c3435c91b6391b773dcd4b","07569c63e2c3435c91b6391b773dcd4b");
        MAP.put("400/fb8ddf3046eb49cfb99ddca67dc933c5","fb8ddf3046eb49cfb99ddca67dc933c5");
        MAP.put("400/94c4879c1e21496198979de0ab09d610","94c4879c1e21496198979de0ab09d610");
        MAP.put("400/35cf22c614124837a9155370c2e25348","35cf22c614124837a9155370c2e25348");
        MAP.put("400/f1c627f75d384adb93d462f4dc8f27dc","f1c627f75d384adb93d462f4dc8f27dc");
        MAP.put("100/3f2fed2614634c229192bd08fe242c59","3f2fed2614634c229192bd08fe242c59");
        MAP.put("100/2d5cfa57f75548bda56cdeb317e82146","2d5cfa57f75548bda56cdeb317e82146");
        MAP.put("400/de188f99de8e428d8618930ef77fae34","de188f99de8e428d8618930ef77fae34");
        MAP.put("500/1ba1b8d2622f4fe9ae1ae77747c389be","1ba1b8d2622f4fe9ae1ae77747c389be");
        MAP.put("400/31ac6b77963a4cb79f860282be7641d4","31ac6b77963a4cb79f860282be7641d4");
        MAP.put("300/39351f9e183340709d1ed2b085dc28f6","39351f9e183340709d1ed2b085dc28f6");
        MAP.put("300/b08030fbc51e4120941e7eb598c3df8e","b08030fbc51e4120941e7eb598c3df8e");
        MAP.put("400/3c9d8aa15a6b4dedb85f19f089abde0a","3c9d8aa15a6b4dedb85f19f089abde0a");
        MAP.put("500/15471b14c9104c85950a76bf424a14bf","15471b14c9104c85950a76bf424a14bf");
        MAP.put("400/0a0e5db4ad9441feb30f8293434fd846","0a0e5db4ad9441feb30f8293434fd846");
        MAP.put("100/f47a545b9bca4569b798888b73db0691","f47a545b9bca4569b798888b73db0691");
        MAP.put("400/7c5022bd6d7543b5a03d75d1ec671cfa","7c5022bd6d7543b5a03d75d1ec671cfa");
        MAP.put("300/fbe04137b23c40f59874d682d75dba07","fbe04137b23c40f59874d682d75dba07");
        MAP.put("300/f0e11957e3be4ed7bf00dc6f415b8a62","f0e11957e3be4ed7bf00dc6f415b8a62");
        MAP.put("100/42c4451ee43a4b0f83ebe6bfc5c16296","42c4451ee43a4b0f83ebe6bfc5c16296");
        MAP.put("400/57de721338984a199e8d0bc43fa361ec","57de721338984a199e8d0bc43fa361ec");
        MAP.put("400/02400e95e6dc485e8a391d63eb644616","02400e95e6dc485e8a391d63eb644616");
        MAP.put("300/36b57c51556149b28adb48aeaa5ac0c7","36b57c51556149b28adb48aeaa5ac0c7");
        MAP.put("500/089ec82622f2441ab7a2ac3d0eb070e2","089ec82622f2441ab7a2ac3d0eb070e2");
        MAP.put("500/499a2b1c6a2d487281f039c7b93458aa","499a2b1c6a2d487281f039c7b93458aa");
        MAP.put("300/230ce7033ec74062bb674c60bc89b1d2","230ce7033ec74062bb674c60bc89b1d2");
        MAP.put("300/b79cc5dc56fd49aa850b5a98e77b1768","b79cc5dc56fd49aa850b5a98e77b1768");
        MAP.put("400/489808b2932d437ba19d7140cee28456","489808b2932d437ba19d7140cee28456");
        MAP.put("300/76cc44969f904820aad89cbec3cebc51","76cc44969f904820aad89cbec3cebc51");
        MAP.put("100/bf56554f93e64f3abd3c9848edc4c6a0","bf56554f93e64f3abd3c9848edc4c6a0");
        MAP.put("600/3528e98b6ff7499091aecb6c5d9382a5","3528e98b6ff7499091aecb6c5d9382a5");
        MAP.put("300/59022bdb580a4209beceaf6f4465305d","59022bdb580a4209beceaf6f4465305d");
        MAP.put("300/a7acc73324a34453aaa1c66d49e124ca","a7acc73324a34453aaa1c66d49e124ca");
        MAP.put("100/8472d7c061c44aa7bb9547f59021699d","8472d7c061c44aa7bb9547f59021699d");
        MAP.put("300/16824b99a58b453ca4af1c97adb6e695","16824b99a58b453ca4af1c97adb6e695");
        MAP.put("400/d09e51c34e13463789598c11681db9c9","d09e51c34e13463789598c11681db9c9");
        MAP.put("600/ac59b512b8d8428d8786776d8d7d2d1c","ac59b512b8d8428d8786776d8d7d2d1c");
        MAP.put("100/150e0e74b0dc4cfca9d4b5214d333d73","150e0e74b0dc4cfca9d4b5214d333d73");
        MAP.put("400/a22c018f26a84841ac6f3f795364a1e5","a22c018f26a84841ac6f3f795364a1e5");
        MAP.put("400/47ce12c3e2cb4e3d891246df86954489","47ce12c3e2cb4e3d891246df86954489");
        MAP.put("400/9096bfdcc065401f8936c229e5901fd2","9096bfdcc065401f8936c229e5901fd2");
        MAP.put("100/2a4634201be04a5ab68da00ac09d14d3","2a4634201be04a5ab68da00ac09d14d3");
        MAP.put("300/4cd47106e8384abeb7d47fafdbfb463c","4cd47106e8384abeb7d47fafdbfb463c");
        MAP.put("400/47652bbde9444280a050d8154710388b","47652bbde9444280a050d8154710388b");
        MAP.put("600/8aed9c50cb824ac1a97ac27b50295772","8aed9c50cb824ac1a97ac27b50295772");
        MAP.put("300/2f5965e2eca742bab47fe1160d926a82","2f5965e2eca742bab47fe1160d926a82");
        MAP.put("400/25e99b203c5e491c8723cbed79701cdb","25e99b203c5e491c8723cbed79701cdb");
        MAP.put("500/237c457ef11847d1b6c7b33c7a8e0c82","237c457ef11847d1b6c7b33c7a8e0c82");
        MAP.put("100/c06d92474d8549d88df030c51657ff8a","c06d92474d8549d88df030c51657ff8a");
        MAP.put("100/a1286a6b862f4bc5a2d491575e5771b3","a1286a6b862f4bc5a2d491575e5771b3");
        MAP.put("600/8262240143124f17911b9b3dca0beb1e","8262240143124f17911b9b3dca0beb1e");
        MAP.put("100/2807eecc732342319dc92b18b5d87eb1","2807eecc732342319dc92b18b5d87eb1");
        MAP.put("500/fb43b942a1b9473aae7741ec75088e76","fb43b942a1b9473aae7741ec75088e76");
        MAP.put("200/7e256e4ae2804effbc874b1c3060c3ad","7e256e4ae2804effbc874b1c3060c3ad");
        MAP.put("500/2f6d990dcbf743f5bc12c7286e3d1f62","2f6d990dcbf743f5bc12c7286e3d1f62");
        MAP.put("500/ff6cf22043e0462f9c3869326d8ff69b","ff6cf22043e0462f9c3869326d8ff69b");
        MAP.put("600/bc459a94da4c421c98bbee533f2038fd","bc459a94da4c421c98bbee533f2038fd");
        MAP.put("200/66ca4a15e89742c9905eddace9491afa","66ca4a15e89742c9905eddace9491afa");
        MAP.put("400/9a6f9b72e03a4affa1f66380f9a7ccc9","9a6f9b72e03a4affa1f66380f9a7ccc9");
        MAP.put("400/5f7f7b715c1340e6a69ab2d39025048d","5f7f7b715c1340e6a69ab2d39025048d");
        MAP.put("600/8aa3b7be2d584ea8b22c251cea80b3d3","8aa3b7be2d584ea8b22c251cea80b3d3");
        MAP.put("500/82c01a1b2f7d4a46aef6263f57b88033","82c01a1b2f7d4a46aef6263f57b88033");
        MAP.put("200/c1152c595afa47aea466006433347c1a","c1152c595afa47aea466006433347c1a");
        MAP.put("500/cbca727895b240a19ecf5cec0cf9fece","cbca727895b240a19ecf5cec0cf9fece");
        MAP.put("400/55a06f32fd4240379af3543181791f7d","55a06f32fd4240379af3543181791f7d");
        MAP.put("400/cf58c3d0b8a1435ba09468280ae2395c","cf58c3d0b8a1435ba09468280ae2395c");
        MAP.put("600/104241e0704548188fff3fb32e27ee03","104241e0704548188fff3fb32e27ee03");
        MAP.put("100/8757a215053e4db4994210183aa5687b","8757a215053e4db4994210183aa5687b");
        MAP.put("600/5ec0b5f869874bf19ab1d6b8f53e66ed","5ec0b5f869874bf19ab1d6b8f53e66ed");
        MAP.put("400/54cb1c42a3c3491085ebc0f5a44af485","54cb1c42a3c3491085ebc0f5a44af485");
        MAP.put("500/4901910e9896470f9b4e269976eb6c6f","4901910e9896470f9b4e269976eb6c6f");
        MAP.put("100/9ec6fff7ce254f2e8b3d17225ddaade5","9ec6fff7ce254f2e8b3d17225ddaade5");
        MAP.put("400/83dd48cb1e86496a862288a19a3745b5","83dd48cb1e86496a862288a19a3745b5");
        MAP.put("100/b5cda69537c0419f8e46f8067b00c5a7","b5cda69537c0419f8e46f8067b00c5a7");
        MAP.put("400/95e095683ec54c4cbb2f5b030c21c80b","95e095683ec54c4cbb2f5b030c21c80b");
        MAP.put("400/0feaba57decb40eb889258ddf2302444","0feaba57decb40eb889258ddf2302444");
        MAP.put("300/75b527c667254753b36830fa95fe63aa","75b527c667254753b36830fa95fe63aa");
        MAP.put("400/fb6a9fed48f24b2d8a1463f2b58216cd","fb6a9fed48f24b2d8a1463f2b58216cd");
        MAP.put("400/0b6bfbbc0d5a4d83a99b1b4dd15a8bb4","0b6bfbbc0d5a4d83a99b1b4dd15a8bb4");
        MAP.put("200/625d34eef60242708ba3ff3a624e65e7","625d34eef60242708ba3ff3a624e65e7");
        MAP.put("300/eca6b5bc24cf4016846e35103ec0da3d","eca6b5bc24cf4016846e35103ec0da3d");
        MAP.put("400/06165f191f42421bb00383576b34868a","06165f191f42421bb00383576b34868a");
        MAP.put("500/0e1a013c890242ef83d6c8d6ac3f8955","0e1a013c890242ef83d6c8d6ac3f8955");
        MAP.put("100/8f36ed563d4d430183b70f4a1e88c3a1","8f36ed563d4d430183b70f4a1e88c3a1");
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
