package com.spring.first.vo;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class StudentVo implements Serializable {


    @NotBlank(message="用户名不能为空")
    private String name;

    @Min(value=18,message = "年龄不能小于18岁")
    private Integer age;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
   public  void setAge(Integer age){
        this.age=age;

   }
   public  int getAge(){
        return age;
   }

}
