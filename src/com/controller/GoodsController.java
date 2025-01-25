package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Goods;
import com.service.GoodsService;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/goods", produces = "text/plain;charset=utf-8")
public class GoodsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CateService cateService;

	@RequestMapping("preNum.action")
	public String preNum(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		return "admin/goodsNum";
	}

	@RequestMapping("status.action")
	public String status(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		String storage = this.getRequest().getParameter("num");
		goods.setNum(storage);
		goods.setBirthday(VeDate.getStringDateShort());
		this.goodsService.updateGoods(goods);
		return "redirect:/goods/preNum.action?id=" + id;
	}

	// 准备添加数据
	@RequestMapping("createGoods.action")
	public String createGoods() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		this.getRequest().setAttribute("goodsno", "G" + VeDate.getStringDatex());
		return "admin/addgoods";
	}

	// 添加数据
	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		goods.setNum("0");
		this.goodsService.insertGoods(goods);
		return "redirect:/goods/createGoods.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		this.goodsService.deleteGoods(id);
		return "redirect:/goods/getAllGoods.action";
	}

	// 批量删除数据
	@RequestMapping("deleteGoodsByIds.action")
	public String deleteGoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("goodsid");
		if (ids != null) {
			for (String goodsid : ids) {
				this.goodsService.deleteGoods(goodsid);
			}
		}
		return "redirect:/goods/getAllGoods.action";
	}

	// 更新数据
	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		this.goodsService.updateGoods(goods);
		return "redirect:/goods/getAllGoods.action";
	}

	// 显示全部数据
	@RequestMapping("getAllGoods.action")
	public String getAllGoods(String number) {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		PageHelper.getUserPage(goodsList, "goods", "getAllGoods", 10, number, this.getRequest());
		return "admin/listgoods";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryGoodsByCond.action")
	public String queryGoodsByCond(String cond, String name, String number) {
		Goods goods = new Goods();
		if (cond != null) {
			if ("goodsno".equals(cond)) {
				goods.setGoodsno(name);
			}
			if ("goodsname".equals(cond)) {
				goods.setGoodsname(name);
			}
			if ("cateid".equals(cond)) {
				goods.setCateid(name);
			}
			if ("image".equals(cond)) {
				goods.setImage(name);
			}
			if ("price".equals(cond)) {
				goods.setPrice(name);
			}
			if ("num".equals(cond)) {
				goods.setNum(name);
			}
			if ("birthday".equals(cond)) {
				goods.setBirthday(name);
			}
			if ("place".equals(cond)) {
				goods.setPlace(name);
			}
			if ("memo".equals(cond)) {
				goods.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.goodsService.getGoodsByLike(goods), "goods", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygoods";
	}

	// 按主键查询数据
	@RequestMapping("getGoodsById.action")
	public String getGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editgoods";
	}

}
