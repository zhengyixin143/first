package com.spring.first.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


public class StudentsVo implements Serializable {
    @NotBlank(message = "手机号不能为空")
    private String phone;

    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }

    @Valid
    private List<StudentVo> studentVo;


    public List<StudentVo> getStudentVo() {
        return studentVo;
    }

    public void setStudentVo(List<StudentVo> studentVo) {
        this.studentVo = studentVo;
    }
}

