package cn.bonjour.jmail.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UEncoder;

import cn.bonjour.jmail.bean.Mail;
import cn.bonjour.jmail.bean.Receiver;
import cn.bonjour.jmail.bean.Sender;
import cn.bonjour.jmail.utils.MailUtil;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String useremail = request.getParameter("email");
		String userfile = request.getParameter("file");
		System.out.println(userfile);
		Mail mail = new Mail();
		// 均通过我的126邮箱发送
		Sender sender = new Sender();
		sender.setHost("smtp.126.com");
		sender.setEmail("dongwq0911@126.com");
		sender.setUsername("dongwq0911");
		sender.setPassword("csuzjudwq@0911");
		sender.setAttachmentPath(userfile);
		mail.setSender(sender);

		Receiver receiver = new Receiver();
		receiver.setEmail(useremail);
		mail.setReceiver(receiver);
		String basicMsg = "<html><body>欢迎注册ZJU系统," + username + "!<br/>";
		String rel = "<h2><a href='http://www.baidu.com'>" + username + "</a></h2></body></html";
		mail.setContent(basicMsg+rel);
		new MailUtil().sendMail(mail);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
