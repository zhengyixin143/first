package com.spring.first.vo;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class NodeVo {
    @NotNull(message = "name不能为空")
    @NotBlank(message = "name不能为空")
    private String name;
    private String title;
    private  int  status;
    private  int  sort;
    private  int pid;
    private int level;
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }


    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status=status;
    }

    public int getSort(){
        return sort;
    }
    public void setSort(int sort){
        this.sort=sort;
    }


    public void setPid(int pid){
        this.pid=pid;
    }
    public int getPid(){
        return pid;
    }

    public void setLevel(int level){
        this.level=level;
    }
    public int getLevel(){
        return level;
    }
}
