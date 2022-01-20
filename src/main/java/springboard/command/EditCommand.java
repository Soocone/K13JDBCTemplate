package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

/*
 BbsCommandImpl 인터페이스를 구현했으므로 추상메서드인 execute()는 반드시 
 오버라이딩 해야한다. 또한 해당 객체는 부모타입인 BbsCommandImpl로
 참조할 수 있다.
 */
public class EditCommand implements BbsCommandImpl{

	@Override
	public void execute(Model model) {
		//Model에 저장된 request 내장객체를 얻어온다.
		Map<String, Object> paramMap = model.asMap();
		//현재 Object형으로 저장된 request 객체를 원래의 형으로 형변환 해준다.
		HttpServletRequest req = (HttpServletRequest)paramMap.get("req");
		
		//일련번호를 파라미터로 받은 후
		String idx = req.getParameter("idx");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();	
		
		//기존의 게시물을 얻어온다
		SpringBbsDTO dto = dao.view(idx);	
		model.addAttribute("viewRow", dto);
//		dao.close();
	}
}
