package sdut.wsl;

import java.sql.SQLException;

import sdut.wsl.dao.CourseDao;
import sdut.wsl.model.Course;

public class DataInserter {
	public static void insert()
	{
		CourseDao cd=new CourseDao();
		Course []cs={
				new Course("001","计算机科学与软件工程导论",null),
				new Course("002","程序设计基础一",null),
				new Course("003","离散数学",null),
				new Course("004","程序设计基础二","001"),
				new Course("005","面向对象程序设计",null),
				new Course("006","数据结构与算法","002"),
				new Course("007","Web开发基础",null),
				new Course("008","操作系统原理",null),
				new Course("009","脚本编程技术",null),
				new Course("010","Java语言程序设计","005"),
				new Course("011","计算机组成原理",null),
				new Course("012","数据库系统原理",null),
				new Course("013","JavaWeb程序设计","007"),
				new Course("014",".Net语言程序设计","004"),
				new Course("015","编译原理",null),
				new Course("016","软件工程",null)
		};
		for(Course c:cs)
		{
			try {
				cd.insert(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
