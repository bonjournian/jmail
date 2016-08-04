package cn.bonjour.jmail.bean;

/**
 * 发件人的信息：服务器地址、邮箱、用户名、密码
 * @author Administrator
 *
 */
public class Sender {
	private String host;
	private String email;
	private String username;
	private String password;
	private String attachmentPath;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
}
