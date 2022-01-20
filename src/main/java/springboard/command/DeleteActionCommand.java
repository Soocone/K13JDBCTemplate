package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class DeleteActionCommand implements BbsCommandImpl {

	@Override
	public void execute(Model model) {
		//Model에 저장된 값을 Map 컬렉션으로 변환한다.
		Map<String, Object> map = model.asMap();
		//첫번째로 request 내장객체를 가져온다.
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		String idx = req.getParameter("idx");
		String pass = req.getParameter("pass");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();

		dao.delete(idx, pass);
		
	}
}
