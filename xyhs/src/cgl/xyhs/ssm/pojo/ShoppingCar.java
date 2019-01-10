package cgl.xyhs.ssm.pojo;

import java.util.List;

public class ShoppingCar {
    private Integer scId;

    private Integer userId;

    private Integer goodsId;
    
    private Integer goodsNum;
    
    private List<Goods> goods;

    public Integer getScId() {
        return scId;
    }

	public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

	/**
	 * @return the goodsNum
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}

	/**
	 * @param goodsNum the goodsNum to set
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * @return the goods
	 */
	public List<Goods> getGoods() {
		return goods;
	}

	/**
	 * @param goods the goods to set
	 */
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	 /* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ShoppingCar [scId=" + scId + ", userId=" + userId + ", goodsId=" + goodsId + ", goodsNum=" + goodsNum
					+ ", goods=" + goods + "]";
		}
}