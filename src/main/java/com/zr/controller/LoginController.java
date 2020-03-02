package com.zr.controller;
/*vdjvndjvndjvf eyreufheifhbrbru ufrhfjdfvdjvnjfdefriehf jfefvnh*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.LoginService;

public class LoginController extends HttpServlet{
	LoginService  loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//假定你拿到数据之后，我们就可以做对应的逻辑处理
		System.out.println(req.getParameter("uname"));
		String uname = req.getParameter("uname");
		//抽象到服务层上面 服务层就代表对应的逻辑
		String result =loginService.loginByName(uname);
		//1.如果是同步的方式 
		//1.1 先将需要的数据存储
		//req.getSession().setAttribute("result", result);
		//1.2 返回到对应页面的当中(同步的动作)
		//req.getRequestDispatcher("demo1.jsp").forward(req, resp);
		//通过异步的方式回写数据
		PrintWriter  wr =  resp.getWriter();
		wr.write(result);
		wr.flush();
		wr.close();
		
	}

}
