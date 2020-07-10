package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import vo.ArtVO;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return getProcess(req,resp);
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			return postProcess(req,resp);
		}
		
		return "";
	}

	private String postProcess(HttpServletRequest req, HttpServletResponse resp) {
		int n = 0;
		
		Service s = new Service();
		ArtVO vo = new ArtVO();
		
		vo.setArtist_id(req.getParameter("artist_id"));
		vo.setArtist_name(req.getParameter("artist_name"));
		vo.setArtist_birth(req.getParameter("artist_year") + req.getParameter("artist_month") + req.getParameter("artist_day"));
		vo.setArtist_gender(req.getParameter("artist_gender"));
		vo.setTalent(req.getParameter("talent"));
		vo.setAgency(req.getParameter("agency"));
		
		try {
			n = s.artInsert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(n > 0) {
			return "redirect::/list";
		}else {
			return "insert";
		}		
	}

	private String getProcess(HttpServletRequest req, HttpServletResponse resp) {
		return "insert";
	}

}
