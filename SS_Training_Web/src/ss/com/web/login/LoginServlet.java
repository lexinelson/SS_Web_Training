package ss.com.web.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] accounts = {{"admin", "lexi"}, {"password", "nelson"}};
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		PrintWriter responder = response.getWriter();
		
		if (Arrays.asList(accounts[0]).contains(user)) {
			int index = Arrays.asList(accounts[0]).indexOf(user);
			if (pass.equals(accounts[1][index])) {
				responder.print(getSuccessPage(user));
			}
			else {
				responder.print(getFailPage(user));
			}
		} else {
			responder.print(getFailPage(user));
		}
	}
	
	private String getSuccessPage(String user) {
		StringBuffer page = new StringBuffer("<html><body><h1>Success!</h1>");
		page.append("<p>It looks like " + user + " is a valid username...</p>");
		page.append("<p>And you seem to have entered the correct password!</p></body></html>");
		return page.toString();
	}
	
	private String getFailPage(String user) {
		StringBuffer page = new StringBuffer("<html><body><h1>Failure</h1>");
		page.append("<p>It looks like " + user + " is not a valid username...</p>");
		page.append("<p>Or you may have put in the wrong password.</p>");
		page.append("<p>Please go back and try again.</p></body></html>");
		return page.toString();
	}

}
