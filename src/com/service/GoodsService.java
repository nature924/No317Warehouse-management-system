package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Goods;
@Service("goodsService")
public interface GoodsService {
	// 插入数据 调用goodsDAO里的insertGoods配置
	public int insertGoods(Goods goods);

	// 更新数据 调用goodsDAO里的updateGoods配置
	public int updateGoods(Goods goods);

	// 删除数据 调用goodsDAO里的deleteGoods配置
	public int deleteGoods(String goodsid);

	// 查询全部数据 调用goodsDAO里的getAllGoods配置
	public List<Goods> getAllGoods();

	// 查询最新上架商品
	public List<Goods> getGoodsByNews();

	// 查询热门商品
	public List<Goods> getGoodsByHot();

	// 查询按分类查询N个商品首页显示
	public List<Goods> getGoodsByCate(String cateid);

	// 按照Goods类里面的字段名称精确查询 调用goodsDAO里的getGoodsByCond配置
	public List<Goods> getGoodsByCond(Goods goods);

	// 按照Goods类里面的字段名称模糊查询 调用goodsDAO里的getGoodsByLike配置
	public List<Goods> getGoodsByLike(Goods goods);

	// 按主键查询表返回单一的Goods实例 调用goodsDAO里的getGoodsById配置
	public Goods getGoodsById(String goodsid);

}

