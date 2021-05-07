package com.example.listviewanddate;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String code;
    private String name;
    private int sex;

    public NhanVien() {
    }

    public NhanVien(String code, String name, int sex) {
        this.code = code;
        this.name = name;
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}


