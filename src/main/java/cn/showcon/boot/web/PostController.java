package cn.showcon.boot.web;

import cn.showcon.boot.feign.JSONPlaceHolderClient;
import cn.showcon.boot.feign.Post;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/6/27
 */
@RestController
@RequestMapping("/api/v1/public")
@Slf4j
public class PostController {
    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;


    @GetMapping("/post")
    public List<Post> post(){
        long start = System.currentTimeMillis();
        List<Post> posts = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts1-{}",System.currentTimeMillis()-start);
        List<Post> posts1 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts2-{}",System.currentTimeMillis()-start);
        List<Post> posts2 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts3-{}",System.currentTimeMillis()-start);
        List<Post> posts3 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts4-{}",System.currentTimeMillis()-start);
        List<Post> posts4 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts5-{}",System.currentTimeMillis()-start);
        List<Post> posts5 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts6-{}",System.currentTimeMillis()-start);
        List<Post> posts6 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts7-{}",System.currentTimeMillis()-start);
        List<Post> posts7 = jsonPlaceHolderClient.getPosts();
        log.info("耗时posts8-{}",System.currentTimeMillis()-start);
        List<Post> posts8 = jsonPlaceHolderClient.getPosts();
        return posts;
    }
    @GetMapping("/get")
    public Post get(Long id){
        return jsonPlaceHolderClient.getPostById(id);
    }
}
