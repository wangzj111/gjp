package com.gjp.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ledger {

    private String parent;

    private double money;
    private int sid;
    private String account;
    private String createtime;
    private String lcomment;



    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLcomment() {
        return lcomment;
    }

    public void setLcomment(String lcomment) {
        this.lcomment = lcomment;
    }

    public Ledger(ResultSet resultSet) throws SQLException {

        this.parent = resultSet.getString("parent");
        this.money = resultSet.getDouble("money");
        this.sid = resultSet.getInt("sid");
        this.account = resultSet.getString("account");
        this.createtime = resultSet.getString("createtime");
        this.lcomment = resultSet.getString("lcomment");
    }

    @Override
    public String toString() {
        return "Ledger{" +
                ", parent='" + parent + '\'' +
                ", money=" + money +
                ", sid=" + sid +
                ", account='" + account + '\'' +
                ", createtime='" + createtime + '\'' +
                ", lcomment='" + lcomment + '\'' +
                '}';
    }
}
