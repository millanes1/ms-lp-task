package com.mxi.maintsuite;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class MyApplication extends Application {

    public MyApplication() {
        Info info = new Info();
        info.description("Description");
        info.setVersion("1.0");
        info.setTitle("title");


        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0");
        beanConfig.setDescription("RESTful resources");
        beanConfig.setTitle("RESTful API");
        beanConfig.setInfo(info);
        beanConfig.setHost("localhost:8080");
        beanConfig.setScan(true);
        // beanConfig.setBasePath("http://localhost:9080/v1/api");
        beanConfig.setResourcePackage(MyApplication.class.getPackage().getName());

    }
}