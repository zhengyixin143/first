package com.spring.first.domain;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "node")
public class Node extends JpaRepositoriesAutoConfiguration {
    @Id //主键注解一定要加上，不然要抛异常
    @GeneratedValue
    private long id;
    private String name;
    private String title;
    private  int  status;
    private  int  sort;
    private  int pid;
    private int level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
