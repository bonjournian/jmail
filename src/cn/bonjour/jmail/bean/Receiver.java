package cn.bonjour.jmail.bean;

import java.util.Set;

/**
 * 收件人信息：收件人邮箱、抄送人邮箱
 * 
 * @author Administrator
 *
 */
public class Receiver {
	private String email;
	Set<String> cc = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getCc() {
		return cc;
	}

	public void setCc(Set<String> cc) {
		this.cc = cc;
	}

}
