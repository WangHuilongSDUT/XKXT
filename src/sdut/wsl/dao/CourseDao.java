package sdut.wsl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sdut.wsl.model.Course;


public class CourseDao {
	public List findAll() throws SQLException
	{
		QueryRunner runner=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM Course";
		List list=(List)runner.query(sql, new BeanListHandler(Course.class));
		return list;
	}
	
	public Course find(String Cno) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM Student WHERE Cno=?";
		Course ret=(Course) qr.query(sql, new BeanHandler(Course.class),new Object[] {Cno});
		return ret;
	}
	
	public boolean insert(Course cs) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="INSERT INTO Course VALUES (?,?,?)";
		int num=qr.update(sql,new Object[] {cs.getCno(),cs.getCname(),cs.getCpno()});
		if(num>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean delete(String Cno) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="DELETE FROM Course WHERE Cno=?";
		int num=qr.update(sql,Cno);
		if(num>0)
		{
			return true;
		}
		return false;
	}
}
