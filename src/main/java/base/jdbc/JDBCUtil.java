package base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 13722 on 2017/10/30.
 */
public class JDBCUtil {

    public static Connection getConnection(){
        Connection conn = null;
        String url="jdbc:mysql://localhost:3306/my_db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String userName="root";
        String password="123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动！");
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection(url, userName, password);
            if(conn!=null){
                System.out.println("connection successful");
            }
        } catch (SQLException e) {
            System.out.println( "connection fail");
            e.printStackTrace();
        }
        return conn;
    }
}
