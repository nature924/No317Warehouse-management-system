package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Sell;
@Service("sellService")
public interface SellService {
	// 插入数据 调用sellDAO里的insertSell配置
	public int insertSell(Sell sell);

	// 更新数据 调用sellDAO里的updateSell配置
	public int updateSell(Sell sell);

	// 删除数据 调用sellDAO里的deleteSell配置
	public int deleteSell(String sellid);

	// 查询全部数据 调用sellDAO里的getAllSell配置
	public List<Sell> getAllSell();

	// 按照Sell类里面的字段名称精确查询 调用sellDAO里的getSellByCond配置
	public List<Sell> getSellByCond(Sell sell);

	// 按照Sell类里面的字段名称模糊查询 调用sellDAO里的getSellByLike配置
	public List<Sell> getSellByLike(Sell sell);

	// 按主键查询表返回单一的Sell实例 调用sellDAO里的getSellById配置
	public Sell getSellById(String sellid);

}

