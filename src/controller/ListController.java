package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.ArtVO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s = new Service();
		List<ArtVO> list = s.artList();
		
		req.setAttribute("list", list);
		return "list";
	}

}
