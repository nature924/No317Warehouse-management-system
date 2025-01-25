package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SellDAO;
import com.entity.Sell;
import com.service.SellService;

@Service("sellService")
public class SellServiceImpl implements SellService {
	@Autowired
	private SellDAO sellDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSell(Sell sell) {
		return this.sellDAO.insertSell(sell);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSell(Sell sell) {
		return this.sellDAO.updateSell(sell);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSell(String sellid) {
		return this.sellDAO.deleteSell(sellid);
	}

	@Override // 继承接口的查询全部
	public List<Sell> getAllSell() {
		return this.sellDAO.getAllSell();
	}

	@Override // 继承接口的按条件精确查询
	public List<Sell> getSellByCond(Sell sell) {
		return this.sellDAO.getSellByCond(sell);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Sell> getSellByLike(Sell sell) {
		return this.sellDAO.getSellByLike(sell);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Sell getSellById(String sellid) {
		return this.sellDAO.getSellById(sellid);
	}

}

