package cn.showcon.boot.mapper;

import cn.showcon.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: hhh
 * @Date: 2021/3/31 10:59 上午
 * @Description TODO
 */
@Mapper
public interface UserDao {

    User getUserById(Long id);


    List<User> getAllUserCondition(@Param("username") String username,@Param("id")Integer id);
}
