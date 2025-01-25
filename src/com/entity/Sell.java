package com.entity;

import com.util.VeDate;

public class Sell {
	private String sellid = "S" + VeDate.getStringId();// 生成主键编号
	private String sno;// 账单号
	private String employid;// 经手人
	private String customername;// 客户名称
	private String total;// 总计金额
	private String addtime;// 创建日期
	private String status;// 状态
	private String memo;// 备注
	private String employname;// 映射数据

	public String getSellid() {
		return sellid;
	}

	public void setSellid(String sellid) {
		this.sellid = sellid;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getEmployid() {
		return this.employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Sell [sellid=" + this.sellid + ", sno=" + this.sno + ", employid=" + this.employid + ", customername="
				+ this.customername + ", total=" + this.total + ", addtime=" + this.addtime + ", status=" + this.status
				+ ", memo=" + this.memo + ", employname=" + this.employname + "]";
	}

}
