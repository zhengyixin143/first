package com.spring.first.domain;

public class Person {
    private long id;
    private String name;
    private int age;
    private String hobby;

    @Override
    public String toString(){
        return "name:"+name+";age="+age+";hobby:"+hobby;
      //  return "bfjfrjf";
    }


}
