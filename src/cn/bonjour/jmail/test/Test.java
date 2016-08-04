package cn.bonjour.jmail.test;

import java.util.HashSet;
import java.util.Set;

import cn.bonjour.jmail.bean.Mail;
import cn.bonjour.jmail.bean.Receiver;
import cn.bonjour.jmail.bean.Sender;
import cn.bonjour.jmail.utils.MailUtil;

public class Test {

	public static void main(String[] args) {
		Mail mail = new Mail();
		Sender sender = new Sender();
		sender.setHost("smtp.126.com");
		sender.setEmail("dongwq0911@126.com");
		sender.setUsername("dongwq0911");
		sender.setPassword("csuzjudwq@0911");
		mail.setSender(sender);

		Receiver receiver = new Receiver();
		receiver.setEmail("dongwq0911@zju.edu.cn");
		Set<String> cc = new HashSet<String>();
		cc.add("1179313112@qq.com");
		cc.add("csudwq@163.com");
		receiver.setCc(cc);
		mail.setReceiver(receiver);

		mail.setSubject("第一封邮件");
		String content = "<html><title>Apache的Jmail测试</title><body>" + "<h2>" + mail.getSender().getUsername()
				+ "</h2</body></html>";
		mail.setContent(content);
		
		new MailUtil().sendMail(mail);
	}

}
