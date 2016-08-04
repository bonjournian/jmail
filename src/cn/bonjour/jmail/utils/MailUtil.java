package cn.bonjour.jmail.utils;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

import cn.bonjour.jmail.bean.Mail;

public class MailUtil {

	public boolean sendMail(Mail mail) {
		// 1 创建一封邮件
		HtmlEmail email = new HtmlEmail();
		// 2 封装邮件信息
		try {
			email.setHostName(mail.getSender().getHost());
			// 2.1 发件人
			email.setFrom(mail.getSender().getEmail());
			// 2.2 收件人
			email.addTo(mail.getReceiver().getEmail());
			// 2.3 抄送人
			// email.setCc(mail.getReceiver().getCc());
			if (mail.getReceiver().getCc() != null) {
				Iterator<String> ccIterator = mail.getReceiver().getCc().iterator();
				while (ccIterator.hasNext()) {
					email.addCc(ccIterator.next());
				}
			}
			// 2.4 编码
			email.setCharset(Mail.ENCODEING);
			// 2.5 主题
			email.setSubject(mail.getSubject());
			// 2.6 内容
			email.setMsg(mail.getContent());
			// 2.7 附件
			if(mail.getSender().getAttachmentPath()!=null) {
				File file = new File(mail.getSender().getAttachmentPath());
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(file.getPath());
				attachment.setName(file.getName());
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				email.attach(attachment);
			}
			// 3 验证发件人的合法性
			email.setAuthentication(mail.getSender().getUsername(), mail.getSender().getPassword());
			// 4 发送
			email.send();
			return true;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			System.out.println("发送异常");
			e.printStackTrace();
		}
		return false;
	}
}