package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Details;
import com.entity.Employ;
import com.entity.Goods;
import com.entity.Sell;
import com.service.DetailsService;
import com.service.EmployService;
import com.service.GoodsService;
import com.service.SellService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/sell", produces = "text/plain;charset=utf-8")
public class SellController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private SellService sellService;
	@Autowired
	private EmployService employService;
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private GoodsService goodsService;

	// 准备添加数据
	@RequestMapping("createSell.action")
	public String createSell() {
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		this.getRequest().setAttribute("sno", "S" + VeDate.getStringDatex());
		return "admin/addsell";
	}

	// 添加数据
	@RequestMapping("addSell.action")
	public String addSell(Sell sell) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		sell.setEmployid(adminid);
		sell.setAddtime(VeDate.getStringDateShort());
		sell.setStatus("待审核");
		double total = 0;
		String sno = sell.getSno();
		Details details = new Details();
		details.setSno(sno);
		List<Details> detailsList = this.detailsService.getDetailsByCond(details);
		for (Details x : detailsList) {
			total += Double.parseDouble(x.getTotal());
		}
		sell.setTotal("" + VeDate.getDouble(total));
		this.sellService.insertSell(sell);
		return "redirect:/sell/createSell.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSell.action")
	public String deleteSell(String id) {
		this.sellService.deleteSell(id);
		return "redirect:/sell/getAllSell.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSellByIds.action")
	public String deleteSellByIds() {
		String[] ids = this.getRequest().getParameterValues("sellid");
		if (ids != null) {
			for (String sellid : ids) {
				this.sellService.deleteSell(sellid);
			}
		}
		return "redirect:/sell/getAllSell.action";
	}

	// 更新数据
	@RequestMapping("updateSell.action")
	public String updateSell(Sell sell) {
		this.sellService.updateSell(sell);
		return "redirect:/sell/getAllSell.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "订单发货";
		Sell sell = this.sellService.getSellById(id);
		sell.setStatus(status);
		this.sellService.updateSell(sell);
		String sno = sell.getSno();
		Details details = new Details();
		details.setSno(sno);
		List<Details> detailsList = this.detailsService.getDetailsByCond(details);
		for (Details x : detailsList) {
			Goods goods = this.goodsService.getGoodsById(x.getGoodsid());
			goods.setNum("" + (Integer.parseInt(goods.getNum()) - Integer.parseInt(x.getNum())));
			this.goodsService.updateGoods(goods);
		}
		String employid = sell.getEmployid();
		Employ employ = this.employService.getEmployById(employid);
		employ.setTotal("" + (Double.parseDouble(employ.getTotal()) + Double.parseDouble(sell.getTotal())));
		this.employService.updateEmploy(employ);
		return "redirect:/sell/getAllSell.action";
	}

	@RequestMapping("refuse.action")
	public String refuse(String id) {
		String status = "订单作废";
		Sell sell = this.sellService.getSellById(id);
		sell.setStatus(status);
		this.sellService.updateSell(sell);
		return "redirect:/sell/getAllSell.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSell.action")
	public String getAllSell(String number) {
		List<Sell> sellList = this.sellService.getAllSell();
		PageHelper.getUserPage(sellList, "sell", "getAllSell", 10, number, this.getRequest());
		return "admin/listsell";
	}

	@RequestMapping("getMySell.action")
	public String getMySell(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Sell sell = new Sell();
		sell.setEmployid(adminid);
		List<Sell> sellList = this.sellService.getSellByCond(sell);
		PageHelper.getUserPage(sellList, "sell", "getAllSell", 10, number, this.getRequest());
		return "admin/xlistsell";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySellByCond.action")
	public String querySellByCond(String cond, String name, String number) {
		Sell sell = new Sell();
		if (cond != null) {
			if ("sno".equals(cond)) {
				sell.setSno(name);
			}
			if ("employid".equals(cond)) {
				sell.setEmployid(name);
			}
			if ("customername".equals(cond)) {
				sell.setCustomername(name);
			}
			if ("total".equals(cond)) {
				sell.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				sell.setAddtime(name);
			}
			if ("status".equals(cond)) {
				sell.setStatus(name);
			}
			if ("memo".equals(cond)) {
				sell.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.sellService.getSellByLike(sell), "sell", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysell";
	}

	// 按主键查询数据
	@RequestMapping("getSellById.action")
	public String getSellById(String id) {
		Sell sell = this.sellService.getSellById(id);
		this.getRequest().setAttribute("sell", sell);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editsell";
	}

	@RequestMapping("getDetail.action")
	public String getDetail(String id) {
		Sell sell = this.sellService.getSellById(id);
		this.getRequest().setAttribute("sell", sell);
		return "admin/detail";
	}

}
