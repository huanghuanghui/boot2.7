package cn.showcon.boot;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/*
 * 功能描述: <br>
 * 〈AIO客户端 发送一串字符串到服务端，同时在CompletionHandler接口处理服务端发送过来的结果〉
 * @Param:
 * @Return:
 * @Author: 
 * @Date: 2021/3/22 16:09
 */
public class AIOClinent {
    private AsynchronousSocketChannel client;

    public AIOClinent() throws Exception {
        //开启客户端
        client = AsynchronousSocketChannel.open();
    }

    public void connect(String host, int port) throws Exception {
        //attachment指要附加到I/O操作的对象
        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                try {
                    //把一个byte数组或byte数组的一部分包装成ByteBuffer
                    client.write(ByteBuffer.wrap("这是一条测试数据".getBytes())).get();
                    System.out.println("已发送到服务器");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.toString());
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        final ByteBuffer bb = ByteBuffer.allocate(1024);
        client.read(bb, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("I/O操作完成" + result);
                System.out.println("获取返回结果" + new String(bb.array()));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new AIOClinent().connect("localhost", 8000);
    }
}