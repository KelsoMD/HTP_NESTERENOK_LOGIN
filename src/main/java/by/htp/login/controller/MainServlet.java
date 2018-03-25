package by.htp.login.controller;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionManager;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BaseAction act = ActionManager.defineAction(request.getParameter("action"));
		try {
			String page = act.act(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ParseException | IOException | ServletException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BaseAction act = ActionManager.defineAction(request.getParameter("action"));

		try {
			String page = act.act(request);
			if (page != null && (page.equals(PAGE_LOGIN)||page.equals(PAGE_REGISTER))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(page);
			}
		} catch (ParseException | IOException | ServletException | IllegalStateException e) {
			e.printStackTrace();
		}

	}

}
