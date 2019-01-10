/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgl.xyhs.ssm.mapper.ShoppingCarMapper;
import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.pojo.ShoppingCar;
import cgl.xyhs.ssm.service.ShoppingService;

/**
* @ClassName: ShoppingServiceImpl.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月8日 下午9:01:53 
 */
@Service
public class ShoppingServiceImpl implements ShoppingService{
    
	@Autowired
	private ShoppingCarMapper mapper;
	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.ShoppingService#selectByUserId(java.lang.Integer)
	 */
	@Override
	public List<ShoppingCar> selectByUserId(Integer userId,Integer start,Integer end) {
		return mapper.selectByUserId(userId,start,end);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.ShoppingService#addShopping(cgl.xyhs.ssm.pojo.ShoppingCar)
	 */
	@Override
	public int addShopping(ShoppingCar sc) {
		ShoppingCar sc1;
		if((sc1 = mapper.selectByGoodsId(sc.getGoodsId()))!=null) {
			  sc1.setGoodsNum(sc1.getGoodsNum()+1);  
			  return mapper.updateByPrimaryKeySelective(sc1);
		} 
		return mapper.insertSelective(sc);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.ShoppingService#deleteByGoodsId(java.lang.Integer)
	 */
	@Override
	public int deleteByGoodsId(Integer goodsId) {
		return mapper.deleteByGoodsId(goodsId);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.ShoppingService#updateShopping(cgl.xyhs.ssm.pojo.ShoppingCar)
	 */
	@Override
	public int updateShopping(ShoppingCar car) {
		return mapper.updateByPrimaryKeySelective(car);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.ShoppingService#getGoodsCount(java.lang.Integer)
	 */
	@Override
	public int getGoodsCount(Integer id) {
		return mapper.getGoodsCount(id);
	}
	
	public ShoppingCar getInfo(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

}
