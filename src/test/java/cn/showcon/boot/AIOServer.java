package cn.showcon.boot;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 功能描述: <br>
 * 〈AIO服务端  主要功能就是开启一个监听端口，然后在CompletionHandler中处理接收到的消息后的逻辑，将接收到的信息在输出到客户端〉
 * @Param:
 * @Return:
 * @Author: 
 * @Date: 2021/3/22 15:22
 */
public class AIOServer {
    private final int port;

    public AIOServer(int port) {
        this.port = port;
        listen();
    }

    //监听服务
    private void listen() {
        try {
            //创建一个线程池
            //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
            ExecutorService executorService = Executors.newCachedThreadPool();
            //创建具有给定线程池的异步通道组。
            //每一个asynchronous channel都属于同一个group，共享一个Java线程池
            //AsynchronousChannelGroup其内部其实是一个(一些)线程池来进行实质工作的；
            // 而他们干的活就是等待IO事件，处理数据，分发各个注册的completion handlers。
            //initialSize参数作为其可以提交的初始任务数的提示
            AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //AsynchronousServerSocketChannel还是AsynchronousSocketChannel的创建都使用各自的静态方法open，
            // 而open方法便需要asynchronousChannelGroup。
            //创建AIO服务通道
            final AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(threadGroup);
            //InetSocketAddress创建IP地址为通配符地址的套接字地址端口号为指定值。
            server.bind(new InetSocketAddress(port));
            System.out.println("服务已启动,监听端口" + port);
            //server.accept此方法是用户当一个新的连接产生时，绑定到同一个AsynchronousChannelGroup
            //CompletionHandler 用于处理程序完成的结果
            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                //设置缓冲区大小为1024字节
                final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    System.out.println("I/O操作成功,开始获取数据");
                    try {
                        //clear清空缓冲区。
                        buffer.clear();
                        result.read(buffer).get();
                        // 用于buffer缓存对象内容填写后，转为读模式。（写进buffer后再flip()，可以读出buffer中的数据）
                        //四个关键的概念，position,limit,mark,capacity
                        //中文就叫位置，限制，标记，容量，他们的关系0<=mark<=position<=limit<capacity
                        //底层操作实际上是操作的数组
                        //capacity可以理解为数组的大小，position就是读取或写入时的下标，limit就是执行当前读或者写的最大下标
                        //还有一个mark，可以理解为一个备份点。使用reset()方法，就可以回到这个点
                        buffer.flip();
                        result.write(buffer);
                        buffer.flip();
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    } finally {
                        try {
                            result.close();
                            server.accept(null, this);
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    }
                    System.out.println("操作完成");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("I/O操作失败:" + exc);
                }
            });
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        int port = 8000;
        new AIOServer(port);
    }
}