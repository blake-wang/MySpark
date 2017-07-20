package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
public class GoddessDao {
    //增加
    public void addGoddess(Goddess g) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "insert into imooc_goddess(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) values (?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译sql，减少sql执行
        //传参
        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getCreate_user());
        ptmt.setString(8, g.getUpdate_user());
        ptmt.setInt(9, g.getIsDel());

        //执行
        ptmt.execute();

    }

    //更新
    public void updateGoddess(Goddess g) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        String sql = "update imooc_goddess set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=? where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdate_user());
        ptmt.setInt(8, g.getIsDel());
        ptmt.setInt(9, g.getId());

        //执行
        ptmt.execute();
    }
    //更新
    public void updateGoddess() throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        String sql = "update imooc_goddess set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=? where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, "无与伦比");
        ptmt.setInt(2, 999);
        ptmt.setInt(3, 888);
        ptmt.setDate(4, new Date(2017,12,19));
        ptmt.setString(5, "wangleimsg@gmail.com");
        ptmt.setString(6, "18588661775");
        ptmt.setString(7, "xingxing");
        ptmt.setInt(8, 2);
        ptmt.setInt(9, 27);

        //执行
        ptmt.execute();
    }

    //删除
    public void delGoddess() throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "delete from imooc_goddess where id = ? or id =?";  //要删除2条记录，要用 or ，不能用and
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setInt(1, 2);
        ptmt.setInt(2,19);
        //执行
        ptmt.execute();
    }

    //查  stmt.executeQuery(sql)    这个例子查询2列
    public List<Goddess> query() throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "select user_name,age from imooc_goddess";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Goddess> gs = new ArrayList<>();
        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            String user_name = rs.getString("user_name");
            int age = rs.getInt("age");
            g.setUser_name(user_name);
            g.setAge(age);
            gs.add(g);
        }
        return gs;
    }

    //查  ptmt.executeQuery() 指定条件查询
    public Goddess get() throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from imooc_goddess where id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, 6);
        ResultSet rs = ptmt.executeQuery();
        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsDel(rs.getInt("isdel"));
        }
        return g;
    }
}

