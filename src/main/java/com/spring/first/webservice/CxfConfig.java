package com.spring.first.webservice;
import com.spring.first.webservice.service.HelloService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


@Configuration
public class CxfConfig {
    @Autowired
    private HelloService helloService;

    @Autowired
    private Bus bus;

    @Bean(name= "cxfServlet")
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/webservicedemo/*");
    }

   @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
   }
    /**
     * 注册HelloService接口到webservice服务
     * @return
     * 浏览器访问地址   http://localhost:9090/webservicedemo?wsdl 得到客户端访问地址 http://localhost:9090/webservicedemo/webservicedemo?wsdl
     *
     */

    @Bean
    public Endpoint endpointHelloService(){
        EndpointImpl endpoint=new EndpointImpl(bus,helloService);
        endpoint.publish("/webservicedemo");
        return  endpoint;
    }






}
