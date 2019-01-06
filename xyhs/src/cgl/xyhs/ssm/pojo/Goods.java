package cgl.xyhs.ssm.pojo;

import java.io.Serializable;
import java.util.Date;


/**
* @ClassName: Goods.java
* @Description: 商品持久化类 对应goods_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:03:45 
 */
public final class Goods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8655787484752313121L;

	private Integer goodsId;

    private String goodsName;

    private Integer goodsType;

    private Integer goodsStatus;

    private Date upTime;

    private Double price;

    private String goodsImg;

    private String introduce;

    private Integer userId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsType=" + goodsType + ", goodsStatus="
				+ goodsStatus + ", upTime=" + upTime + ", price=" + price + ", goodsImg=" + goodsImg + ", introduce="
				+ introduce + ", userId=" + userId + "]";
	}
    
    
}