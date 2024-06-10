import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/Login")

public class Login_Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myemail =req.getParameter("email");
		String mypass=req.getParameter("pass");
		
		PrintWriter out=resp.getWriter();
		
		if(myemail.equals("deepa@gmail.com")&& mypass.equals("deepa123"))
		{
			//req.setAttribute("name_key", "Deepanjali Ishte");
			
			HttpSession session=req.getSession();
			session.setAttribute("name_key", "Deepanjali Ishte");
					
			RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			out.print("Email id and password did not matched");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
			//rd.forward(req, resp);
			rd.include(req, resp);
			
		}
	}
}
