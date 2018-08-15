package com.linkinstars.springBootTemplate.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Druid监控配置
 * @author LinkinStar
 */
@Configuration
public class DruidConfig {

    /**
     * 配置spy数据源
     */
    @Bean
    @Primary
    public DataSource spyDataSource(@Qualifier("druidDataSource") DataSource druidDataSource){
        return new DataSourceSpy(druidDataSource);
    }

    /**
     * 配置读取spring数据源
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控启动页面
     */
    @Bean
    public ServletRegistrationBean druidStartViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //白名单：
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");

        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");

        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    /**
     * Druid监控过滤器配置规则
     */
    @Bean
    public FilterRegistrationBean druidStartFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");

        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
