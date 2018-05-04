package ex0503_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String words [] = {
			"�ڹ� ���α׷���","Ajax","�ں���","������","�߻����",
			"���","����ϴ°���","����","��������ʹ�","ħ�뿴����",
			"���� �ſ�","�ǰ��ϴ�","��û","����","�λ��̶�","���� ��","���2���� �ƴѰ�",
			"�ں��� ����","�ں��� �ڽ�"
	};
	
	/**
	 * ù �ܾ ������ �ܾ ã�Ƽ� list�� ��� �����ϴ� �޼ҵ� �ۼ�
	 */
	private List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word : words) {
			if(word.toLowerCase().startsWith(keyWord.toLowerCase())) {
				list.add(word);
			}
		}	
		return list;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //post��� �ѱ� ���ڵ� ����
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		
		//front���� ������ ����
		PrintWriter out = response.getWriter();
		
/*		//front�� �����͸� �����ϱ� ���ؼ� text�������� ��ȯ�غ���
		//����|�ܾ�, �ܾ�, �ܾ�,...
		out.print(list.size()+"|");
		
		for(int i =0; i<list.size();i++) {
			if(i==(list.size()-1)) out.print(list.get(i));		
			else out.print(list.get(i)+",");
		}*/
		
		///////////////////////////////////////////////////////////////////////////
		// list�� json���·� ��ȯ�ؼ� front�� ������ [{},{},{}]
		JSONArray jsonArr = JSONArray.fromObject(list);
		out.print(jsonArr);
		
		
		
		
		
		

	}
}
