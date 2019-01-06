/**
 * 
 */
package cgl.xyhs.ssm.service;

import java.util.List;

import cgl.xyhs.ssm.pojo.Goods;

/**
 * @ClassName: GoodsService.java
 * @Description: 商品服务层接口
 * @version: v1.0.0
 * @author: CGL
 * @date: 2019年1月4日 上午11:28:44
 */
public interface GoodsService {
	List<Goods> getByType(Integer type);
    
	/**
	 * 用户查看自己的商品信息详情
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	List<Goods> getByUser(Integer id,Integer start,Integer end);
    int searchUserGoodsCount(Integer id);
	/**
	 * 分页选择商品
	 * @param type
	 * @param start
	 * @param end
	 * @return
	 */
	List<Goods> getByTypePage(Integer type,Integer start,Integer end);
	int searchTypeGoodsCount(Integer type);
	
	Goods getInfoById(Integer id);
	
	/**
	 * 更新商品信息
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);
	
	/**
	 * 用于用户更改自己商品信息
	 * @param goods
	 * @return
	 */
	int updateGoodsByUser(Goods goods);

	int addGoods(Goods goods);
	
	int deleteGoods(Integer id);
	
	int deleteMany(Integer[] id);
}
