package cgl.xyhs.ssm.pojo;

import java.io.Serializable;
import java.util.Date;


/**
* @ClassName: Evaluate.java
* @Description: 用户评论类 对应eva_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:03:10 
 */
public final class Evaluate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -541631536117811641L;

	private Integer evaId;

    private Integer evaSellerId;

    private String sellerName;

    private Integer buyerId;

    private String buyerName;

    private Date evaTime;

    private Double evaStarlevel;

    private String evaContent;

    private String evaImg;

    private String evaResponse;

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public Integer getEvaSellerId() {
        return evaSellerId;
    }

    public void setEvaSellerId(Integer evaSellerId) {
        this.evaSellerId = evaSellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Date getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(Date evaTime) {
        this.evaTime = evaTime;
    }

    public Double getEvaStarlevel() {
        return evaStarlevel;
    }

    public void setEvaStarlevel(Double evaStarlevel) {
        this.evaStarlevel = evaStarlevel;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent;
    }

    public String getEvaImg() {
        return evaImg;
    }

    public void setEvaImg(String evaImg) {
        this.evaImg = evaImg;
    }

    public String getEvaResponse() {
        return evaResponse;
    }

    public void setEvaResponse(String evaResponse) {
        this.evaResponse = evaResponse;
    }
}