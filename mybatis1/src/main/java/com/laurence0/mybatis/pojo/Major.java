package com.laurence0.mybatis.pojo;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author Dominic Wang
 * @Date 2024/5/23 09:10
 * @注释
 */
public class Major implements Serializable {
    private String majorNo;
    private String majorName;

    public Major() {
    }

    public Major(String majorNo, String majorName) {
        this.majorNo = majorNo;
        this.majorName = majorName;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
