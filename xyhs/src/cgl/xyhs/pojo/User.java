/**
 * 
 */
package cgl.xyhs.pojo;

import java.io.Serializable;

/**
* @ClassName: User.java
* @Description: 用户持久化类 对应user_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:05:21 
 */
public class User implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 869325252569521024L;
	
	private Integer userId;
	
	private String userImg;
	
	private String userName;
	
	private String userPass;
	
	private Boolean userStatus;
	
	private String userTel;
	
	private String userAddress;
	
	private String userPostAddress;
	
	private Double userStarlevel;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostAddress() {
		return userPostAddress;
	}

	public void setUserPostAddress(String userPostAddress) {
		this.userPostAddress = userPostAddress;
	}

	public Double getUserStarlevel() {
		return userStarlevel;
	}

	public void setUserStarlevel(Double userStarlevel) {
		this.userStarlevel = userStarlevel;
	}
}
