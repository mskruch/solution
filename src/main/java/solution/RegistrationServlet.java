package solution;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet
{
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
			request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("username", username);
		request.getRequestDispatcher("/WEB-INF/jsp/registered.jsp").forward(
			request, response);
	}
}
