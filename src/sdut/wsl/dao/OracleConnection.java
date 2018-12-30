package sdut.wsl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class OracleConnection {
	private static DataSource ds=null;
 	private static Connection conn = null;
    
    private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动
     
    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/wsl"; //连接字符串
     
    private static String username = "system"; //用户名
     
    private static String password = "123456"; //密码
	public static DataSource getDataSource()
	{
		if(null==conn)
		{
			 try 
			 {
		         BasicDataSource bds=new BasicDataSource();
		         bds.setDriverClassName(driver);
		         bds.setUrl(url);
		         bds.setUsername(username);
		         bds.setPassword(password);
		         bds.setInitialSize(5);
		         ds=bds;
		         
			 } 
			 catch (Exception e) 
			 {
		         e.printStackTrace();
		     }
		}
		return ds;
	}
}
