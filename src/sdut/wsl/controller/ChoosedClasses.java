package sdut.wsl.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import sdut.wsl.dao.StudentDao;
import sdut.wsl.model.Student;

/**
 * Servlet implementation class ChoosedClasses
 */
@WebServlet("/ChoosedClasses")
public class ChoosedClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoosedClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods","OPTIONS, GET, PUT, POST, DELETE");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with, x-ui-request， lang");
		//获取User Cookie
		Cookie []cs=request.getCookies();
		Cookie user=null;
		for(Cookie c:cs)
		{
			if(c.getName().equals("user"))
			{
				user=c;
			}
		}
		
		if(null==user)
		{
			response.getWriter().print("Error");
			return;
		}
		
		//获取Session
		HttpSession session=request.getSession(false);
		if(null==session)
		{
			response.getWriter().print("Error");
			return;
		}
		//获取存储的学生信息
		Student s=(Student)session.getAttribute("Student");
		if(null==s)
		{
			response.getWriter().print("Error");
			return;
		}
		List ret=null;
		try {
			ret=new StudentDao().getChoosedClasses(s.getSno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().print("Error");
			e.printStackTrace();
		}
		response.setContentType("text/json;charset=utf-8");
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(ret));
	}

}
