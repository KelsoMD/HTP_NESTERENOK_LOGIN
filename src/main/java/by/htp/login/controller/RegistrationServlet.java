package by.htp.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionManager;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String registerPage = "/register.jsp";
	private String pageError = "/error.jsp";
	private String welcomePage = "/second.jsp";

	public RegistrationServlet() {
		super();

	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher(registerPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		BaseAction act = ActionManager.defineAction("Registration");
		String result = act.act(request);
		if (result.equals("false")) {
			request.setAttribute("errorLogin", "Incorrect login");
			RequestDispatcher dispatcher = request.getRequestDispatcher(registerPage);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(welcomePage);
			dispatcher.forward(request, response);
		}
	}
}
