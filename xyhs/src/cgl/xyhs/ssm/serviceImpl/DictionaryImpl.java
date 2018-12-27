/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgl.xyhs.ssm.mapper.DictionaryMapper;
import cgl.xyhs.ssm.pojo.Dictionary;
import cgl.xyhs.ssm.service.DictionaryService;

/**
* @ClassName: DictionaryImpl.java
* @Description: 数据字典逻辑层实现类
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午9:06:02 
 */

@Service
public class DictionaryImpl implements DictionaryService {
     
	@Autowired
	private DictionaryMapper mapper;
	
	@Override
	public int deleteMany(Integer[] dirId) {
		for (Integer integer : dirId) {
			mapper.deleteByPrimaryKey(integer);
		}
		return dirId.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * zm.village.service.DictionaryService#addDictionary(zm.village.dao.Dictionary)
	 */
	@Override
	public int addDictionary(Dictionary record) {
		return mapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.DictionaryService#getInfo(java.lang.Integer)
	 */
	@Override
	public Dictionary getInfo(Integer dirId) {
		return mapper.selectByPrimaryKey(dirId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.DictionaryService#getByType(java.lang.Integer)
	 */
	@Override
	public List<Dictionary> getByType(Integer type) {
		return mapper.selectByType(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.DictionaryService#getAll()
	 */
	@Override
	public List<Dictionary> getAll() {
		return mapper.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.DictionaryService#update(zm.village.dao.Dictionary)
	 */
	@Override
	public int update(Dictionary record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

}
