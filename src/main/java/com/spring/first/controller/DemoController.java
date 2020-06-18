package com.spring.first.controller;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.xml.transform.Result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.TypeReference;
import com.mysql.cj.xdevapi.JsonArray;
import com.spring.first.service.DemoService;
import com.spring.first.service.NodeService;
import com.spring.first.service.StudentService;
import com.spring.first.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.spring.first.domain.*;
import com.spring.first.vo.StudentsVo;

import java.util.ArrayList;
import java.util.List;


@RestController
public class DemoController {
    @Resource
    private DemoService demoService;

    @Resource
    private NodeService nodeService;

    @Resource
    private StudentService studentService;

    /**
     * 测试保存数据方法.单条保存
     * @return
     */
    @RequestMapping("/demosave")
    public String save(){
        Demo d = new Demo();
        d.setTname("suse");
        d.setHobby("打羽毛球");
        demoService.save(d);//保存数据.
        return "ok.DemoController.save";
    }

    @RequestMapping("/getData")
    @ResponseBody
    //这个方法只能返回单条数据 返回的是json对象
    public ResponseEntity<Object> getData(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(demoService.getDemoByTname(name), HttpStatus.OK);
    }


    @RequestMapping("/getDatas")
    @ResponseBody
    //这个方法可返回多条数据，返回json数组
    public List<Node> findName(@RequestParam(name="name") String name){
        List<Node> bList=nodeService.findByNameLike(name);
        return bList;

    }


    @RequestMapping(value = "/loadTree",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    //这个方法表示接收json对象 {"id":952,"name":"showDebit","title":"显示发票工作区","status":1,"sort":1,"pid":360,"level":3}
    //将json对象放到Node里面，使得json对象可以用Node对象的方法，然后将数据插入到数据表
    public void loadTree(@RequestBody Node jsonObject) {
        Node d = new Node();
        System.out.println(jsonObject.getName());
        d.setLevel(jsonObject.getLevel());
        d.setName(jsonObject.getName());
        d.setPid(jsonObject.getPid());
        d.setTitle(jsonObject.getTitle());
        try{
            nodeService.save(d);//插入数据表
        }catch (Exception e1){
            System.out.println("出现异常："+e1);    //打印异常信息

        }

    }

    @RequestMapping(value = "/loadTree2",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
   // 这个方法表示接收json对象 {"id":952,"name":"555","title":"7777","status":1,"sort":1,"pid":360,"level":3}
   // 用NodeVo验证类来验证json对象中的参数是否符合条件
   public Object loadTree( @Valid @RequestBody  NodeVo jsonObject,BindingResult bindingResult) {
    //  return jsonObject;//返回一个验证结果对象，如果是符合条件的则直接返回数据，否则返回一个消息对象
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();

        }else{
            Node d =new Node();
            d.setTitle(jsonObject.getTitle());
            d.setName(jsonObject.getName());
            d.setLevel(jsonObject.getLevel());
            d.setSort(jsonObject.getSort());
            nodeService.save(d);
        }
        return jsonObject;


    }


    /*该方法可接收json数组字串 [{"id":8,"name":"showDebit","title":null,"status":0,"sort":0,"pid":360,"level":3},
     {"id":952,"name":"showDebit","title":"显示发票工作区3","status":1,"sort":1,"pid":360,"level":3},
     {"id":982,"name":"showDebit","title":"发票工作区","status":0,"sort":1,"pid":222,"level":3}]
     这里遇到一个坑，就是如果数据表是自己另外在数据库建的，而不是由框架建的，或者数据表已经有历史数据存在，
     那么可能会出现框架存的自增长主键和实际表的自增长主键值不一致，导致新增报错*/
    @RequestMapping(value = "/testarray",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void jsonAdd(@RequestBody String datas){
        System.out.println(datas);
        JSONArray jsonArray;
        jsonArray=JSON.parseArray(datas);//将json数组字符串转成jsonArray，jsonArray相当于是josnObeject的集合
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Node d=new Node();
            d.setTitle(jsonObject.getString("title"));
            d.setName(jsonObject.getString("name"));
            d.setPid(jsonObject.getInteger("pid"));
            d.setSort(jsonObject.getInteger("sort"));
            d.setLevel(jsonObject.getInteger("level"));
            nodeService.save(d);//插入node表

           // System.out.println("json数组传递过来的参数为:" + "第" + i + "条:" + "\n" + );
        }


    }


    /*这个方法可验证json对象里面的json数组的参数值合法性
    *{
	"phone":"3333",
	"studentVo":[{"name":"showDebit","age":2},{"name":"showDebit","age":18},{"name":"showDebit","age":18}]}
    * 比如上述示例的年龄age不能小于18岁
    * */
    @RequestMapping(value="/stu",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addStu(@Validated @RequestBody StudentsVo jsonobject,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
          //  return
        }else{
            List array=jsonobject.getStudentVo();
            JSONArray jsonArray=JSON.parseArray(JSON.toJSONString(array));//将list转换为jsonarray

            for (int i=0;i<jsonArray.size();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Student s=new Student();
                s.setName(jsonObject.getString("name"));
                s.setAge(jsonObject.getInteger("age"));
                studentService.save(s);

            }
           // System.out.println(jsonArray);
            return "success";
        }


    }




    @RequestMapping(value="/stu1",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    /*
    *[{"conditionname":"a.commitTime","conditionops":">=","conditionvalue":"2020-04-14"},
     {"conditionname":"a.commitTime","conditionops":"<=","conditionvalue":"2020-04-22"}]
    * */
    public List<Node> query( @RequestBody String datas){

       ArrayList<QueryCodtionVo> queryCodtionVoArrayList=JSON.parseObject(datas,new TypeReference<ArrayList<QueryCodtionVo>>(){});
       String condtionStrin="";
       for(QueryCodtionVo queryCodtionVo:queryCodtionVoArrayList){
           condtionStrin=condtionStrin+queryCodtionVo.toString();

       }
        condtionStrin=condtionStrin.substring(0,condtionStrin.length()-4);
        System.out.println(condtionStrin);
        List<Node> bList=nodeService.selectNodes(condtionStrin);
        return bList;






    }





}
