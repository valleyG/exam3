package com.nm.exam3.poji;

public class Student {
    private Integer sId;
    private Integer cId;
    private String sName;
    private String sSex;
    private Integer sAge;
    private String cName;

    public String getcName() {
        return cName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", cId=" + cId +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sAge=" + sAge +
                ", cName='" + cName + '\'' +
                '}';
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public Student() {
    }

    public Student(Integer sId, Integer cId, String sName, String sSex, Integer sAge) {
        this.sId = sId;
        this.cId = cId;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
    }

}
