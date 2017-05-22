package unp.student.work.manager.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
* Description: TODO
* @author 
* @date 2017�?2�?25�? 下午2:37:05
 */
public class JDBCUtil {
	private static final String CONNURL = "jdbc:mysql://139.199.61.77:3306/studentworkmanagement?useUnicode=true&characterEncoding=utf8";
	private static final String USERNAME = "unp";
	private static final String PASSWORD = "wearehero";
	/*使用静�?�代码块完成驱动的加�?*/
	static {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*提供连接的方�?*/
	public static Connection getConnection() {
		Connection con = null;
		try {
			//连接指定的MMySQL数据库，三个参数分别是：数据库地�?、账号�?�密�?
			con = DriverManager.getConnection(CONNURL,USERNAME , PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	/*关闭连接的方�?*/
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
