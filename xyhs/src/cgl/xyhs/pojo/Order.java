package cgl.xyhs.pojo;

import java.io.Serializable;
import java.util.Date;


/**
* @ClassName: Order.java
* @Description: 订单类 对应order_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:04:23 
 */
public class Order implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2247949231234332215L;

	private Integer orderId;

    private String orderUmber;

    private Date orderRetime;

    private Date orderStarttime;

    private Date orderEndtime;

    private Integer orderUserid;

    private String orderUsertel;

    private String orderUsername;

    private Integer userid;

    private String userName;

    private String usertel;

    private String address;

    private Double price;

    private String imgurl;

    private Boolean orderStatus;

    private Boolean orderManner;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderUmber() {
        return orderUmber;
    }

    public void setOrderUmber(String orderUmber) {
        this.orderUmber = orderUmber;
    }

    public Date getOrderRetime() {
        return orderRetime;
    }

    public void setOrderRetime(Date orderRetime) {
        this.orderRetime = orderRetime;
    }

    public Date getOrderStarttime() {
        return orderStarttime;
    }

    public void setOrderStarttime(Date orderStarttime) {
        this.orderStarttime = orderStarttime;
    }

    public Date getOrderEndtime() {
        return orderEndtime;
    }

    public void setOrderEndtime(Date orderEndtime) {
        this.orderEndtime = orderEndtime;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public String getOrderUsertel() {
        return orderUsertel;
    }

    public void setOrderUsertel(String orderUsertel) {
        this.orderUsertel = orderUsertel;
    }

    public String getOrderUsername() {
        return orderUsername;
    }

    public void setOrderUsername(String orderUsername) {
        this.orderUsername = orderUsername;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getOrderManner() {
        return orderManner;
    }

    public void setOrderManner(Boolean orderManner) {
        this.orderManner = orderManner;
    }
}