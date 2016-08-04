package cn.bonjour.jmail.bean;

import java.io.Serializable;

/**
 * 邮件信息： 发件人、收件人、主题、内容、邮件编码格式
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Mail implements Serializable {

	// 邮件编码（解决中文乱码的）
	public static final String ENCODEING = "UTF-8";
	private String host; // 服务器地址
	private Sender sender;
	private Receiver receiver;
	private String subject;
	private String content;// 信息(支持HTML)

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static String getEncodeing() {
		return ENCODEING;
	}

}