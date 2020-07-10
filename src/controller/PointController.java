package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.MentoVO;

public class PointController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s = new Service();
		List<MentoVO> p_list = s.mentoList();
		
		req.setAttribute("p_list", p_list);
		return "point";
		
	}

}
