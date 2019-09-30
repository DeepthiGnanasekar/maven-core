package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() { ///method is used to get DB connection
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/deepthi_db";
        String userName = "deepthi";
        String password = "deepthi";
        Connection con = null;
        try {
            Class.forName(driverClassName);
            System.out.println(url);
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(con);
        return con;
    }
    public static  void close(Connection con, PreparedStatement pst) { ///method is used to close DB connection
        try {
            if (pst != null)
                pst.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

