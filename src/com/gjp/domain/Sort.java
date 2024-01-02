package com.gjp.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sort {
    private int sid;
    private String sname;
    private String parent;
    private String scomment;



    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getScomment() {
        return scomment;
    }

    public void setScomment(String scomment) {
        this.scomment = scomment;
    }

    public Sort(ResultSet resultSet) throws SQLException {
        this.sid = resultSet.getInt("sid");
        this.sname = resultSet.getString("sname");
        this.parent = resultSet.getString("parent");
        this.scomment = resultSet.getString("scomment");
    }
    @Override
    public String toString() {
        return "Sort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", parent='" + parent + '\'' +
                ", scomment='" + scomment + '\'' +
                '}';
    }

}
