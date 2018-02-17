package by.htp.login.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionManager;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String pageSecond = "/login.jsp";
	private String pageError = "/error.jsp";
	private String welcomePage = "/second.jsp";
	private List<String> values = new ArrayList<>();

	{
		values.add("one");
		values.add("two");
		values.add("three");
		values.add("four");
		values.add("five");
	}

	public LoginServlet() {

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageSecond);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("dopost");

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		BaseAction act = ActionManager.defineAction("CheckLogin");
		String actResponce;
		try {
			actResponce = act.act(request);
		
		if (act != null && actResponce.equals("Incorrect password")) {
			request.setAttribute("errorLogin", "Incorrect password");
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageSecond);
			dispatcher.forward(request, response);

		} else if (act != null && actResponce.equals("Incorrect login")) {
			request.setAttribute("errorLogin", "Incorrect login");
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageSecond);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(actResponce);
			dispatcher.forward(request, response);
		}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if (param.equals("test")) {
		//
		// request.setAttribute("user_name", "Alex");
		// request.setAttribute("list", values);
		//
		// RequestDispatcher dispatcher = request.getRequestDispatcher(pageSecond);
		// dispatcher.forward(request, response);
		// System.out.println("Test sucsessfull!");
		// } else {
		// RequestDispatcher dispatcher = request.getRequestDispatcher(pageError);
		// dispatcher.forward(request, response);
		// }
		// }
	}
}
