package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/1/25
 * Description:
 * Modified:
 */
public class DBUtil {


    /**
     * 获取数据库连接
     *
     * @param driver   驱动类
     * @param url      数据库路径
     * @param username 用户名
     * @param password 密码
     * @return 数据库连接
     */
    public static Connection getConnection(String driver, String url, String username, String password) throws Exception {
        Connection conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }



    /**
     * 关闭所有连接
     */
    public static void close(ResultSet rs, Statement stm, Connection conn) {
        if (rs != null) {
            Statement tmpStm = null;
            try {
                tmpStm = rs.getStatement();
                rs.close();
            } catch (Exception e) {
            } finally {
                try {
                    if (tmpStm != null)
                        tmpStm.close();
                } catch (Exception e2) {
                }
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (Exception e2) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e2) {
            }
        }
    }

}
