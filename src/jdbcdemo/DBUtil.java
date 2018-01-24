package jdbcdemo;


import java.sql.*;

/**
 * Created by zhouxu on 2017/12/14 10:12.
 */
public class DBUtil {

    protected static String driver = "com.mysql.jdbc.Driver";
    protected static String url = "jdbc:mysql://localhost:3306/mybatis_day01";
    protected static String dbUser = "root";
    protected static String dbPwd = "root";


    /** 获取数据库连接对象
     * @return
     */
    public static Connection getConnection() {

        Connection connection = null;
        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, dbUser, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


    /** 关闭数据库连接
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {

            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        (1)Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        (2)Connection conn = DriverManager.getConnection("jdbc:odbc:Database1")
//        (3)"select * from Student"
//        (4)stmt.close()
//        (5)  conn.close()

    }

}
