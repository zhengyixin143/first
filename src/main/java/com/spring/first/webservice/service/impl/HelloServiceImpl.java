package com.spring.first.webservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.spring.first.domain.Node;
import com.spring.first.service.NodeService;
import com.spring.first.webservice.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

@Service
@WebService(serviceName = "HelloService",
targetNamespace = "http://service.mq.primeton.com", endpointInterface = "com.spring.first.webservice.service.HelloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public Object sayHello(String content){

        return content;
    }
    @Resource
    private NodeService nodeService;
    @Override
    public String findName(String name){
        List<Node> bList=nodeService.findByNameLike(name);

      //  return bList;如果这里直接return bList则返回的是xml格式的数据

       // List array=jsonobject.getStudentVo();
        String jsonArray= JSON.toJSONString(bList);//将list转换为jsonstring，

        return jsonArray;//这里返回的是jsonstring   例如 [{"id":48,"level":3,"name":"333","pid":0,"sort":1,"status":0,"title":"显示发票工作区3"},{"id":49,"level":3,"name":"333","pid":0,"sort":1,"status":0,"title":"哒哒哒"}]

    }
}
