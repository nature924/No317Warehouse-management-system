package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.Details;
import com.entity.Goods;
import com.service.DetailsService;
import com.service.GoodsService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxController extends BaseController {
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("save.action")
	@ResponseBody
	public String save() {
		String[] x = this.getRequest().getParameter("str").split(",");
		String goodsid = x[0];
		String num = x[1];
		String sno = x[2];
		Goods goods = this.goodsService.getGoodsById(goodsid);
		String status = "OK";
		String msg = "";
		double total = Double.parseDouble(goods.getPrice()) * Double.parseDouble(num);
		if (Double.parseDouble(goods.getNum()) >= Double.parseDouble(num)) {
			Details details = new Details();
			details.setGoodsid(goodsid);
			details.setNum(num);
			details.setPrice(goods.getPrice());
			details.setSno(sno);
			details.setTotal("" + VeDate.getDouble(total));
			this.detailsService.insertDetails(details);
		} else {
			status = "ERROR";
			msg = goods.getGoodsname() + "  库存不足";
		}
		JSONObject json = new JSONObject();
		json.put("status", status.toString().replaceAll("\"", ""));
		json.put("msg", msg.toString().replaceAll("\"", ""));
		return json.toString();
	}
}
