package sdut.wsl.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdut.wsl.dao.StudentDao;
import sdut.wsl.model.Student;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods","OPTIONS, GET, PUT, POST, DELETE");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with, x-ui-request， lang");
        String uname=request.getParameter("username");
        String psd=request.getParameter("password");
        StudentDao sd=new StudentDao();
        try {
			Student s=sd.find(uname);
			if(null!=s)
			{
				if(s.getPassword().equals(psd))
				{
					HttpSession session=request.getSession();
					session.setAttribute("Student", s);
					Cookie c=new Cookie("JSESSIONID",session.getId());
					c.setMaxAge(-1);
					response.addCookie(c);
					Cookie usr=new Cookie("user",s.getSname());
					usr.setMaxAge(-1);
					response.addCookie(usr);
					response.getWriter().print("Success");
					return ;
				}
				else
				{
					response.getWriter().print("Failed");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().print("Failed");
		}
		response.getWriter().print("Failed");
	}

}
