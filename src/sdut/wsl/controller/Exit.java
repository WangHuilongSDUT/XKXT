package sdut.wsl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exit
 */
@WebServlet("/Exit")
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);	response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setHeader("Access-Control-Allow-Methods","OPTIONS, GET, PUT, POST, DELETE");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with, x-ui-request， lang");
		request.getSession().removeAttribute("Student");
		request.getSession().invalidate();
		Cookie[] cs=request.getCookies();
		for(Cookie c:cs)
		{
			if(c.getName().equals("user"))
			{
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	}

}
