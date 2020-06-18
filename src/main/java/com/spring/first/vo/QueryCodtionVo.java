package com.spring.first.vo;

public class QueryCodtionVo {
   private String conditionname;
   private String conditionops;
   private String conditionvalue;

    public String getConditionname() {
        return conditionname;
    }

    public void setConditionname(String conditionname) {
        this.conditionname = conditionname;
    }

    public String getConditionops() {
        return conditionops;
    }

    public void setConditionops(String conditionops) {
        this.conditionops = conditionops;
    }

    public String getConditionvalue() {
        return conditionvalue;
    }

    public void setConditionvalue(String conditionvalue) {
        this.conditionvalue = conditionvalue;
    }
    public String toString(){
        if(conditionvalue.length()>0){
            return conditionname+conditionops+"'"+conditionvalue+"'"+" and ";
        }else {
            return "";
        }

    }

}
