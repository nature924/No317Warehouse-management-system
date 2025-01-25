package com.entity;

import com.util.VeDate;

public class Goods {
	private String goodsid = "G" + VeDate.getStringId();// 生成主键编号
	private String goodsno;// 物资号
	private String goodsname;// 物资名称
	private String cateid;// 物资类型
	private String image;// 图片
	private String price;// 销售价格
	private String num;// 库存数量
	private String birthday;// 生产日期
	private String place;// 存放位置
	private String memo;// 备注
	private String catename;// 映射数据

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsno() {
		return this.goodsno;
	}

	public void setGoodsno(String goodsno) {
		this.goodsno = goodsno;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Goods [goodsid=" + this.goodsid + ", goodsno=" + this.goodsno + ", goodsname=" + this.goodsname
				+ ", cateid=" + this.cateid + ", image=" + this.image + ", price=" + this.price + ", num=" + this.num
				+ ", birthday=" + this.birthday + ", place=" + this.place + ", memo=" + this.memo + ", catename="
				+ this.catename + "]";
	}

}
