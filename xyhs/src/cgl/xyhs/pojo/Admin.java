package cgl.xyhs.pojo;

import java.io.Serializable;

/**
* @ClassName: Admin.java
* @Description: 管理员持久化类，对应admin_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午5:57:59 
 */
public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4254421434760581831L;

	//主键Id
    private Integer adminId;
    
    private String adminName;

    private String adminPass;

    private String adminTel;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }
}