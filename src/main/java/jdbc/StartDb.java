package jdbc;


import java.sql.SQLException;
import java.util.Date;

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
public class StartDb {
    public static void main(String[] args) throws SQLException {
        createData();
//        insert2Table();

    }

    //生成数据,一次生成10条并插入数据库
    public static void createData() throws SQLException {
        Goddess g = null;
        GoddessDao dao = new GoddessDao();
        for (int i = 0; i < 10; i++) {
            g = new Goddess();
            g.setUser_name("wanglei" + i);
            g.setSex(i);
            g.setAge(20 + i);
            g.setBirthday(new Date());
            g.setEmail(i + "62939327@qq.com");
            g.setCreate_user("mayun" + i);
            g.setCreate_date(new Date());
            g.setUpdate_user("huateng" + (i + 1));
            g.setUpdate_date(new Date());
            g.setIsDel(i + 3);

            dao.addGoddess(g);
        }
    }

    //向表imooc_goddess添加一条数据
    public static void insert2Table() {
        Goddess g = new Goddess();
        g.setUser_name("wanglei");
        g.setSex(1);
        g.setAge(28);
        g.setBirthday(new Date());
        g.setEmail("362939327@qq.com");
        g.setCreate_user("wanglei");
        g.setCreate_date(new Date());
        g.setUpdate_user("wanglei");
        g.setUpdate_date(new Date());
        g.setIsDel(1);

        GoddessDao dao = new GoddessDao();
        try {
            dao.addGoddess(g);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
