package sdut.wsl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sdut.wsl.model.Course;
import sdut.wsl.model.Student;

public class StudentDao {
	public List getUnchoosedClasses(String Sno) throws SQLException
	{
		// select * from Course,sc where Course.Cno not in (Select cno from sc where sc.sno='160506001');
		QueryRunner runner=new QueryRunner(OracleConnection.getDataSource());
		String sql="select distinct Course.cno,Course.cname,Course.cpno from Course,sc where Course.cno not in (select Cno from sc where sc.sno=?)";
		List list=(List)runner.query(sql, new BeanListHandler(Course.class),new Object[] {Sno});
		return list;
		
	}	
	public List getChoosedClasses(String Sno) throws SQLException
	{
		// select * from Course,sc where Course.Cno not in (Select cno from sc where sc.sno='160506001');
		QueryRunner runner=new QueryRunner(OracleConnection.getDataSource());
		String sql="select distinct Course.cno,Course.cname,Course.cpno from Course,sc where Course.cno=SC.Cno and sc.sno=?";
		List list=(List)runner.query(sql, new BeanListHandler(Course.class),new Object[] {Sno});
		return list;
		
	}
	public List findAll() throws SQLException
	{
		QueryRunner runner=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM Student";
		List list=(List)runner.query(sql, new BeanListHandler(Student.class));
		return list;
	}
	
	public Student find(String Sno) throws SQLException
	{	
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM Student WHERE sno=?";
		Student ret=(Student) qr.query(sql, new BeanHandler(Student.class),new Object[] {Sno});
		return ret;
	}
	
	public boolean insert(Student st) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="INSERT INTO Student VALUES (?,?,?,?,?,?)";
		int num=qr.update(sql,new Object[] {st.getSno(),st.getSname(),st.getSsex(),st.getSage(),st.getSdept(),st.getPassword()});
		if(num>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean delete(String Sno) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="DELETE FROM Student WHERE Sno=?";
		int num=qr.update(sql,Sno);
		if(num>0)
		{
			return true;
		}
		return false;
	}
}
