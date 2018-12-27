package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.Dictionary;


/**
* @ClassName: DictionaryMapper.java
* @Description: 数据字典数据库映射mapper接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:46:55 
 */

@Repository
public interface DictionaryMapper {
	/**
	 * 根据id删除记录
	 * @param dirId 数据的主键id
	 * @return
	 */
    int deleteByPrimaryKey(Integer dirId);
    
    /**
     * 插入新数据
     * @param record
     * @return
     */
    int insertSelective(Dictionary record);
    
    /**
     * 根据主键id选择记录
     * @param dirId
     * @return
     */
    Dictionary selectByPrimaryKey(Integer dirId);
    
    /**
     * 根据商品类型查看某一类型所有数据
     * @param type 数据类型
     * @return
     */
    List<Dictionary> selectByType(Integer type);
    
    /**
     * 查找所有记录
     * @return
     */
    List<Dictionary> selectAll();
    /**
     * 根据判断主键id更新记录
     * @param record 
     * @return
     */
    int updateByPrimaryKeySelective(Dictionary record);
}