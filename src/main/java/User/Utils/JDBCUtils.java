/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package User.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/6/4
 */
public class JDBCUtils {
    private  static DataSource dataSource;
    private static InputStream resource;
    static {
        Properties properties =new Properties();
        resource = JDBCUtils.class.getClassLoader().getResourceAsStream("properties/druid.properties");

        try {
            properties.load(resource);
            //获取DataSource
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}