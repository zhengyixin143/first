package com.spring.first.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.mq.primeton.com")
public interface HelloService {
    @WebMethod
    public  Object sayHello(@WebParam(name="content") String content);


    @WebMethod
    public String findName(@WebParam(name="name") String name);

}
