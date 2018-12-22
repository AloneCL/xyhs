package cgl.xyhs.ssm.pojo;

import java.io.Serializable;

/**
* @ClassName: Dictionary.java
* @Description: 数据字典持久化类，对应dictionary_inf表
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午6:01:56 
 */
public final class Dictionary implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1405602065901537655L;

	private Integer id;

    private Byte goodsType;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}