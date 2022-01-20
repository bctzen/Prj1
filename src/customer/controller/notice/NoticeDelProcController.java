package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;

public class NoticeDelProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDelProcController");
		String seq = request.getParameter("c");
		
		NoticeDao dao = new NoticeDao();
		
		int del = dao.delete(seq);
		
		if (del > 0){
			response.sendRedirect("notice.do");
		} else {
			System.out.println("삭제오류");
		}
	}

}
