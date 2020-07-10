package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	HashMap<String, Controller> list = null;
	String charset = null;
	private final String prefix = "/WEB-INF/view/";
	private final String postfix = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		
		list.put("/", new MainController());
		list.put("/list", new ListController());
		list.put("/insert", new InsertController());
		list.put("/point", new PointController());
		
		charset = config.getInitParameter("charset");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String url = req.getRequestURI();
		Controller c = list.get(url);
		String result = null;
		
		if(c != null) {
			result = c.execute(req, resp);
		}
		if(result.startsWith("redirect::")) {
			result = result.substring("redirect::".length());
			resp.sendRedirect(result);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(prefix + result + postfix);
			dispatcher.forward(req, resp);
		}
	}
}
