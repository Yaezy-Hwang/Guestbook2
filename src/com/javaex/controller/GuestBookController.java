package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestVo;

@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("./gbc --> doGet()"); //테스트 메세지
		
		String action = request.getParameter("action");
		
		if ("main".equals(action)){
			System.out.println("main");//테스트 메세지
			
			BookDao bookDao = new BookDao();
			List<GuestVo> gList = bookDao.select();
			
			//포워드 리퀘스트에 값 넣기
			request.setAttribute("guestlist", gList);
			
			//forword 하는 방법
			WebUtil.forward(request, response, "/WEB-INF/main.jsp");
		
		} else if("insert".equals(action)) {
			System.out.println("insert");//테스트 메세지
			
			
			String name = request.getParameter("name");
			String pw = request.getParameter("password");
			String content = request.getParameter("content");
			
			BookDao bookDao = new BookDao();
			GuestVo gVo = new GuestVo(name, pw, content);
			bookDao.insert(gVo);

			WebUtil.redirect(response, "/gb2/gbc?action=main");
			
		} else if("dform".equals(action)) {
			System.out.println("go deleteform");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			//포워드 리퀘스트에 값 넣기
			request.setAttribute("no", no);
			
			//forword 하는 방법
			WebUtil.forward(request, response, "/WEB-INF/deleteForm.jsp");
			
		} else if("delete".equals(action)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("password");
			
			BookDao bookDao = new BookDao();
			bookDao.delete(no, pw);

			try{
				WebUtil.redirect(response, "/gb2/gbc?action=main");
			} catch(NumberFormatException e){
				WebUtil.redirect(response, "/gb2/gbc?action=dform");
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
