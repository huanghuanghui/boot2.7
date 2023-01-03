package cn.showcon.boot.mybatis;

import cn.showcon.boot.entity.User;
import cn.showcon.boot.mapper.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2023/1/3
 */
public class MybatisTests {
    public static void main(String[] args)throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1 启动mybatis框架
        // SqlSession --> SqlSessionFactory --> SqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取user mapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User userById = userDao.getUserById(1L);
        System.out.println(userById.toString());
    }
}
