package jdbc_imooc;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
public class StartDb {
    public static void main(String[] args) throws SQLException {
//        createData();
//        insert2Table();

//        querySet();
//        queryOne();
//        deleteOne();

        updateOne();

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
            g.setMobile(i+"5814053390");
            g.setCreate_user("mayun" + i);
            g.setCreate_date(new Date());
            g.setUpdate_user("huateng" + (i + 1));
            g.setUpdate_date(new Date());
            g.setIsDel(i + 3);

            //插入数据
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

    //查询数据库  返回数据集
    public static void querySet () throws SQLException {
        GoddessDao dao = new GoddessDao();
        List<Goddess> result = dao.query();
        for(Goddess g : result){
            System.out.println(g.toString());
        }
    }

    //查询数据库  返回一条数据
    public static void queryOne () throws SQLException {
        GoddessDao dao = new GoddessDao();
        Goddess g = dao.get();
        System.out.println(g.toString());
    }

    //删除数据表中一条数据
    public static void deleteOne() throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.delGoddess();
    }

    //更新一条数据
    public static void updateOne() throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.updateGoddess();
    }

}
