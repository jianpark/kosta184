package ex0503_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CustomerDAO dao = new CustomerDAOImpl();
		
		CustomerDTO dto = new CustomerDTO(request.getParameter("id"),request.getParameter("name"),
				Integer.parseInt(request.getParameter("age")),request.getParameter("phone"),request.getParameter("addr"));
		// request.getParameter("id")는 name이 넘어오는거지 id가 아님
		int re = dao.update(dto);

		PrintWriter out = response.getWriter();
		out.println(re);
	}

}
