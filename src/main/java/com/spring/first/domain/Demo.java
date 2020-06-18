package com.spring.first.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity //加入这个注解，Demo就会进行持久化了
@Table(name="demo")
public class Demo {


    @Id
    @GeneratedValue
    private long id;

    @Column(name="tname")
    private String tname;

    @Column(name="hobby")
    private  String hobby;

    public Demo() {
    }
    public Demo(long id, String tname) {
        this.id = id;
        this.tname = tname;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String name) {
        this.tname = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
