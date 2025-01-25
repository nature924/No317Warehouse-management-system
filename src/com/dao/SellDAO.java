package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Sell;

@Repository("sellDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface SellDAO {

	/**
	 * SellDAO 接口 可以按名称直接调用sell.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包sell.xml里的insertSell配置 返回值0(失败),1(成功)
	public int insertSell(Sell sell);

	// 更新数据 调用entity包sell.xml里的updateSell配置 返回值0(失败),1(成功)
	public int updateSell(Sell sell);

	// 删除数据 调用entity包sell.xml里的deleteSell配置 返回值0(失败),1(成功)
	public int deleteSell(String sellid);

	// 查询全部数据 调用entity包sell.xml里的getAllSell配置 返回List类型的数据
	public List<Sell> getAllSell();

	// 按照Sell类里面的值精确查询 调用entity包sell.xml里的getSellByCond配置 返回List类型的数据
	public List<Sell> getSellByCond(Sell sell);

	// 按照Sell类里面的值模糊查询 调用entity包sell.xml里的getSellByLike配置 返回List类型的数据
	public List<Sell> getSellByLike(Sell sell);

	// 按主键查询表返回单一的Sell实例 调用entity包sell.xml里的getSellById配置
	public Sell getSellById(String sellid);

}
