package com.gjp.controller;

import com.gjp.Tools.DRUIDUtils;
import com.gjp.domain.Ledger;

import java.sql.*;
import java.util.Objects;

public class ledgerTableCoontroller {
        /**
         *
         * @param start 起始时间 无下限时间的查询传入null
         * @param end 终止时间 无上限时间的查询传入null
         * @throws SQLException
         * @return 返回结果集
         */
        public static ResultSet dataSelectByDate(String start,String end) throws SQLException {
                String uplimit = "9999-12-2";
                String downlimit = "1970-01-01";
                String sql = "SELECT * FROM ledger WHERE createtime > ? AND createtime < ? ";

                Connection conn = DRUIDUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                if(!Objects.equals(start, "null")) pstmt.setString(1,start); else pstmt.setString(1,downlimit);
                if(!Objects.equals(end, "null")) pstmt.setString(2,end); else pstmt.setString(2,uplimit);

                ResultSet rs = pstmt.executeQuery();
                return rs;
        }

        /**
         *
         * @param led 传入一个ledger类用于传入数据
         * @return 返回是否添加成功
         * @throws SQLException
         */
        public static boolean insertLedgerData(Ledger led) throws SQLException {
                String account = led.getAccount();
                String createtime = led.getCreatetime();
                String lcomment = led.getLcomment();
                int sid = led.getSid();
                double money = led.getMoney();
                String parent = led.getParent();
                String sql = "INSERT INTO ledger (parent, money, sid, account, createtime, lcomment)" +
                        "VALUES ( ?, ?, ?, ?, ?, ?)";

                Connection conn = DRUIDUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, parent);
                pstmt.setDouble(2, money);
                pstmt.setInt(3, sid);
                pstmt.setString(4, account);
                pstmt.setDate(5, Date.valueOf(createtime));
                pstmt.setString(6, lcomment);

                boolean isResult = pstmt.execute();
            return !isResult;


        }

        /**
         *
         * @param led 存储数据的类
         * @param lid 唯一标识（需要更改的行）
         * @return 是否成功
         * @throws SQLException
         */
        public static boolean updateLedgerData(Ledger led,int lid) throws SQLException {
                String account = led.getAccount();
                String createtime = led.getCreatetime();
                String lcomment = led.getLcomment();
                int sid = led.getSid();
                double money = led.getMoney();
                String parent = led.getParent();
                String sql = "UPDATE ledger SET parent = ?, money = ?, sid = ?, account = ?, createtime = ?,lcomment = ?, WHERE lid = ?";

                Connection conn = DRUIDUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, parent);
                pstmt.setDouble(2, money);
                pstmt.setInt(3, sid);
                pstmt.setString(4, account);
                pstmt.setDate(5, Date.valueOf(createtime));
                pstmt.setString(6, lcomment);

                boolean isResult = pstmt.execute();

                return !isResult;
        }

        /**
         *
         * @param lid 标识(需要删除的行标识)
         * @return 是否成功
         * @throws SQLException
         */
        public static boolean deleteLedgerData(int lid) throws SQLException {
                String sql = "DELETE FROM ledger where lid = ? ";

                Connection conn = DRUIDUtils.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,lid);

                boolean isResult = pstmt.execute();

                return !isResult;
        }
}
