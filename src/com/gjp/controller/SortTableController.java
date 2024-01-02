package com.gjp.controller;

import com.gjp.Tools.DRUIDUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SortTableController {
    public static boolean sortTableCreate(String sname,String parent,String scomment) throws SQLException {
        Connection conn = DRUIDUtils.getConnection();
        String sql = "INSERT INTO sort(sname,parent,scomment) VALUES (?,?,?)" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,sname);
        pstmt.setString(2,parent);
        pstmt.setString(3,scomment);

        pstmt.execute();

        pstmt.close();
        conn.close();

        return true;
    }
    public static boolean sortTableDeleteBySname(String value) throws SQLException {
        int sid;
        Connection conn = DRUIDUtils.getConnection();
        sid = toSid(value);
        String s = "SELECT * from ledger where sid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(s);
        pstmt1.setInt(1,sid);
        ResultSet rs = pstmt1.executeQuery();

        if(rs.next()){
            System.out.println("有数据");

        }else{
            System.out.println("没数据");
        }
        pstmt1.close();
        String sql = "DELETE FROM sort WHERE sname = ?" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,value);
        pstmt.execute();

        pstmt.close();
        conn.close();
        return true;
    }
    public static boolean sortTableDeleteByparent(String value) throws SQLException {
        int sid;
        Connection conn = DRUIDUtils.getConnection();
        sid = toSid(value);
        String s = "SELECT * from ledger where sid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(s);
        pstmt1.setInt(1,sid);
        ResultSet rs = pstmt1.executeQuery();

        if(rs.next()){
            System.out.println("有数据");

        }else{
            System.out.println("没数据");
        }
        pstmt1.close();
        String sql = "DELETE FROM sort WHERE parent = ?" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,value);
        pstmt.execute();

        pstmt.close();
        conn.close();
        return true;
    }
    public static boolean sortTableDeleteByscomment(String value) throws SQLException {
        int sid;
        Connection conn = DRUIDUtils.getConnection();
        sid = toSid(value);
        String s = "SELECT * from ledger where sid = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(s);
        pstmt1.setInt(1,sid);
        ResultSet rs = pstmt1.executeQuery();

        if(rs.next()){
            System.out.println("有数据");

        }else{
            System.out.println("没数据");
        }
        pstmt1.close();
        String sql = "DELETE FROM sort WHERE scomment = ?" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,value);
        pstmt.execute();

        pstmt.close();
        conn.close();
        return true;
    }
    /**
     * 这是一个示例方法的注释。
     *
     * @param select 默认为0表示输出所有分类，
     *               1表示输出支出分类，
     *               2表示输出收入分类
     */
    public static void showData(int select) throws SQLException {
        Connection conn = DRUIDUtils.getConnection();
        String sql = "SELECT * FROM sort";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(select == 0){
            while(rs.next()){
                String sname = rs.getString("sname");
                String parent = rs.getString("parent");
                String scomment = rs.getString("scomment");
                System.out.println("分类名称:"+sname+", 所属分类:"+parent+", 备注:"+scomment);
            }
        } else if (select==1) {
            while(rs.next()){
                String sname = rs.getString("sname");
                String parent = rs.getString("parent");
                String scomment = rs.getString("scomment");
                if(parent.equals("支出"))
                    System.out.println("分类名称:"+sname+", 所属分类:"+parent+", 备注:"+scomment);
            }
        } else if (select == 2) {
            while(rs.next()){
                String sname = rs.getString("sname");
                String parent = rs.getString("parent");
                String scomment = rs.getString("scomment");
                if(parent.equals("收入"))
                    System.out.println("分类名称:"+sname+", 所属分类:"+parent+", 备注:"+scomment);
            }

        }
        pstmt.close();
        conn.close();
    }

    /**
     * 这是一个示例方法的注释。
     *
     * @param key 需要查询的字段名
     * @param value 需要查询的值
     * @return 如果有结果返回结果集，没有结果输出提示并返回空
     */
    public static ResultSet selectData(String key,String value) throws SQLException {

        Connection conn = DRUIDUtils.getConnection();
        String sql = "SELECT * FROM sort where ? = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,key);
        pstmt.setString(1,value);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return rs;
        }else{
            System.out.println("没有符合条件的结果！");
            return null;
        }
    }
    public static int toSid(Object... objects) throws SQLException {
        Connection conn = DRUIDUtils.getConnection();
        String sql = "select sid from sort where (sname = ? OR parent = ? OR scomment=? )";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            Object param = objects[i];
            pstmt.setObject(i * 3 + 1, param); // 设置 sname 参数
            pstmt.setObject(i * 3 + 2, param); // 设置 parent 参数
            pstmt.setObject(i * 3 + 3, param); // 设置 scoment 参数
        }
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            int sid = rs.getInt("sid");
            return sid;
        }else{
            return -1;
        }


    }

    /**
     *
     * @param sname 查询根据
     * @param newSname 新的分类名
     * @param parent 新的所属分类
     * @param scomment 新的备注
     * @return 返回是否成功
     * @throws SQLException
     */
    public static boolean sortTableUpdateBySanme(String sname,String newSname,String parent,String scomment) throws SQLException {
        Connection conn = DRUIDUtils.getConnection();
        String sql = "update sort " +
                "set sname = ?,parent=?,scomment=?" +
                "where sname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,newSname);
        pstmt.setString(2,parent);
        pstmt.setString(3,scomment);
        pstmt.setString(4,sname);
        pstmt.execute();
        return true;
    }

}
