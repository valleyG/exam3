package com.nm.exam3.poji;



public class Grade {
    private Integer cId;
    private String cName;

    public Grade(Integer cId) {
        this.cId = cId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Grade(Integer cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public Grade() {

    }

    @Override
    public String toString() {
        return "Grade{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
