/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgl.xyhs.ssm.mapper.GoodsMapper;
import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.service.GoodsService;

/**
* @ClassName: GoodsServiceImpl.java
* @Description: 商品服务层逻辑实现类
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月4日 上午11:41:20 
 */
@Service
public class GoodsServiceImpl implements GoodsService {
     
	@Autowired
	private GoodsMapper mapper;

	
	@Override
	public List<Goods> getByType(Integer type) {
		return mapper.selectByType(type);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#getByUser(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Goods> getByUser(Integer id, Integer start, Integer end) {
		return mapper.selectByUser(id, start, end);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#searchUserGoodsCount(java.lang.Integer)
	 */
	@Override
	public int searchUserGoodsCount(Integer id) {
		return mapper.searchGoodsCount(id);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#getByTypePage(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Goods> getByTypePage(Integer type, Integer start, Integer end) {
		return mapper.selectPage(type, start, end);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#searchTypeGoodsCount(java.lang.Integer)
	 */
	@Override
	public int searchTypeGoodsCount(Integer type) {
		return mapper.searchTypeCount(type);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#getInfoById(java.lang.Integer)
	 */
	@Override
	public Goods getInfoById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#updateGoods(cgl.xyhs.ssm.pojo.Goods)
	 */
	@Override
	public int updateGoods(Goods goods) {
		return mapper.updateByPrimaryKeySelective(goods);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#updateGoodsByUser(cgl.xyhs.ssm.pojo.Goods)
	 */
	@Override
	public int updateGoodsByUser(Goods goods) {
		return mapper.updateByUser(goods);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#addGoods(cgl.xyhs.ssm.pojo.Goods)
	 */
	@Override
	public int addGoods(Goods goods) {
		return mapper.insertSelective(goods);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#deleteGoods(java.lang.Integer)
	 */
	@Override
	public int deleteGoods(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see cgl.xyhs.ssm.service.GoodsService#deleteMany(java.lang.Integer[])
	 */
	@Override
	public int deleteMany(Integer[] id) {
		for(Integer goodsId : id) {
			mapper.deleteByPrimaryKey(goodsId);
		}
		return id.length;
	}
	
	
}
