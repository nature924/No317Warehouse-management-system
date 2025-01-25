package com.entity;

import com.util.VeDate;

public class Employ {
	private String employid = "E" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String employname;// 姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String image;// 照片
	private String contact;// 联系方式
	private String address;// 联系地址
	private String total;// 总业绩
	private String workdate;// 入职日期
	private String memo;// 备注

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Employ [employid=" + this.employid + ", username=" + this.username + ", password=" + this.password
				+ ", employname=" + this.employname + ", sex=" + this.sex + ", birthday=" + this.birthday + ", image="
				+ this.image + ", contact=" + this.contact + ", address=" + this.address + ", total=" + this.total
				+ ", workdate=" + this.workdate + ", memo=" + this.memo + "]";
	}

}
