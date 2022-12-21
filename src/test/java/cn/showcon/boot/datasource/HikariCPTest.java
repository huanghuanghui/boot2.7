package cn.showcon.boot.datasource;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/12/21
 */
public class HikariCPTest {
    public static void main(String[] args) throws Exception{
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://10.36.36.225:3322/mmm");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("dev");
        ds.setPassword("pg2TgGUqX");
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user limit 1 ");
        while (resultSet.next()){
            String id = resultSet.getString("id");
        }
        System.out.println("1");
    }
}
