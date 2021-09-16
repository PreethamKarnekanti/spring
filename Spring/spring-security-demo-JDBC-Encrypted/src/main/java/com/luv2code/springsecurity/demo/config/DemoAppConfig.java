package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    @Autowired
    private Environment env;
    private Logger myLogger= Logger.getLogger(getClass().getName());
    //define a bean for view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver= new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    //define a bean for security  datasource
    @Bean
    public DataSource securityDataSource()
    {
        //create a connection pool
        ComboPooledDataSource securityDataSource =  new ComboPooledDataSource();
        //set the jdbc driver
        try {

            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        }
        catch(Exception ex)
        {
            throw  new RuntimeException(ex);
        }
        //log the connection props
        myLogger.info("jdbc url"+env.getProperty("jdbc.url"));
        myLogger.info("jdbc user"+env.getProperty("jdbc.user"));

        //set the database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        //set the connection pool properties

        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return securityDataSource;
    }
    //need a hleper method....read env property and convert into int
    public int getIntProperty(String propName)
    {
        String propVal=env.getProperty(propName);
        int intPropVal=Integer.parseInt(propVal);
        return intPropVal;
    }
}












