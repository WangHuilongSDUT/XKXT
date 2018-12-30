package sdut.wsl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sdut.wsl.model.SC;

public class SCDao {
	public List findAll() throws SQLException
	{
		QueryRunner runner=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM SC";
		List list=(List)runner.query(sql, new BeanListHandler(SC.class));
		return list;
	}
	
	public SC find(String Sno,String Cno) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="SELECT * FROM SC WHERE Sno=? and Cno=?";
		SC ret=(SC) qr.query(sql, new BeanHandler(SC.class),new Object[] {Sno,Cno});
		return ret;
	}
	
	public boolean insert(SC sc) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="INSERT INTO SC VALUES (?,?,?)";
		int num=qr.update(sql,new Object[] {sc.getSno(),sc.getCno(),sc.getGrade()});
		if(num>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean delete(String Sno,String Cno) throws SQLException
	{
		QueryRunner qr=new QueryRunner(OracleConnection.getDataSource());
		String sql="DELETE FROM SC WHERE Sno=? and Cno=?";
		int num=qr.update(sql,new Object[] {Sno,Cno});
		if(num>0)
		{
			return true;
		}
		return false;
	}
}
