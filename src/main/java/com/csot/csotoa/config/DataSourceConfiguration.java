package com.csot.csotoa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by liushiqi on 2017/6/16.
 */
@Configuration
@PropertySource("classpath:connection-${spring.profiles.active}.properties")
public class DataSourceConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;



    @Bean
    public DataSource dataSource(){
        logger.info("url-------------->>"+url);
        System.out.println("注入druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setDriverClassName(driver);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setInitialSize(1);
        datasource.setMinIdle(1);
        datasource.setValidationQuery("SELECT 1 FROM DUAL");
        datasource.setMaxWait(60000);
        datasource.setMaxActive(10);
        datasource.setMinEvictableIdleTimeMillis(300000);
        return datasource;
    }
}
