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
			"자바 프로그래밍","Ajax","박보검","차은우","잘생겼다",
			"몇개나","써야하는거지","뭐야","집에가고싶다","침대였으면",
			"오늘 매우","피곤하다","엄청","많네","인생이란","나는 왜","재벌2세가 아닌가",
			"박보검 존멋","박보검 핸썸"
	};
	
	/**
	 * 첫 단어가 동일한 단어를 찾아서 list에 담아 리턴하는 메소드 작성
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
		request.setCharacterEncoding("UTF-8"); //post방식 한글 인코딩 설정
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		
		//front보낼 데이터 설정
		PrintWriter out = response.getWriter();
		
/*		//front로 데이터를 전송하기 위해서 text형식으로 변환해본다
		//개수|단어, 단어, 단어,...
		out.print(list.size()+"|");
		
		for(int i =0; i<list.size();i++) {
			if(i==(list.size()-1)) out.print(list.get(i));		
			else out.print(list.get(i)+",");
		}*/
		
		///////////////////////////////////////////////////////////////////////////
		// list를 json형태로 변환해서 front로 보내기 [{},{},{}]
		JSONArray jsonArr = JSONArray.fromObject(list);
		out.print(jsonArr);
		
		
		
		
		
		

	}
}
