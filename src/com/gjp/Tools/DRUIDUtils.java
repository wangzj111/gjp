package com.gjp.Tools;


import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DRUIDUtils {
    public static Connection getConnection() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
        dataSource.setUsername("root");
        dataSource.setPassword("wzj200406");
        return dataSource.getConnection();
    }
}
