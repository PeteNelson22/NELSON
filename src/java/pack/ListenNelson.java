package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenNelson implements ServletContextListener {

    static String name = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/nelson";
    static String username = "root";
    static String password = "NELSON22";

    public static Connection myconnection() {
        Connection con = null;

        try {
            Class.forName(name).newInstance();
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    public void contextInitialized(ServletContextEvent event) {
        try {
            Connection con = myconnection();
            String sql = "create table nelson.Register(name varchar(200),email varchar(200),password varchar(200))";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
