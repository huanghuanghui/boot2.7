package cn.showcon.boot.jackson;

import cn.showcon.boot.MyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/9/14
 */
public class Test {


    public static void main(String[] args) throws Exception{
        System.out.println(writeStringAsString("xxxx"));
    }


    public static String writeStringAsString(String toWrite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(toWrite);
    }


    public static String writePojoAsString(Object toWrite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(toWrite);
    }


    public static String writeIntAsString(int toWrite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(toWrite);
    }


    public static String writeListAsString(List<Object> toWrite) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String r = objectMapper.writeValueAsString(toWrite);
        return r;
    }



    public MyResponse readPojoValue(String toRead) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(toRead, MyResponse.class);
    }
}
