package cgl.xyhs.ssm.pojo;

import java.io.Serializable;

/**
* @ClassName: Ratation.java
* @Description: 首页轮播图实体持久化类 对应ratationimg_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:05:56 
 */
public final class Ratation implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -640272428251592709L;

	private String imgurl1;

    private String imgurl2;

    private String imgurl3;

    public String getImgurl1() {
        return imgurl1;
    }

    public void setImgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getImgurl3() {
        return imgurl3;
    }

    public void setImgurl3(String imgurl3) {
        this.imgurl3 = imgurl3;
    }
}