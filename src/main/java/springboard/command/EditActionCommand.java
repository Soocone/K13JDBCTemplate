package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class EditActionCommand implements BbsCommandImpl {

	@Override
	public void execute(Model model) {
		//Model에 저장된 값을 Map 컬렉션으로 변환한다.
		Map<String, Object> map = model.asMap();
		//첫번째로 request 내장객체를 가져온다.
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		SpringBbsDTO springBbsDTO = (SpringBbsDTO)map.get("springBbsDTO");
		
		//두번째로 작성페이지에서 전송한 모든 폼값이 저장된 DTO 객체를 가져온다.
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		//폼값을 개별적으로 받음
//		String idx = req.getParameter("idx");
//		String name = req.getParameter("name");
//		String title = req.getParameter("title");
//		String contents = req.getParameter("contents");
//		String pass = req.getParameter("pass");
//		dao.edit(idx, name, title, contents, pass);
		
		// DTO 객체를 DAO로 전달한다.
		dao.edit(springBbsDTO);
		
	}
}
