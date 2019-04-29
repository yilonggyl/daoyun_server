package com.zw.admin.server.model;



public class Daoyunuser extends BaseEntity<Long> {

	private String name;
	private String avatar;
	private String userid;
	private String email;
	private String signature;
	private String title;
	private String group;
	private String tags;
	private Integer notifyCount;
	private Integer unreadCount;
	private String country;
	private String geographic;
	private String address;
	private String phone;
	private String password;
	private Integer roleId;
	private String status;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getNotifyCount() {
		return notifyCount;
	}
	public void setNotifyCount(Integer notifyCount) {
		this.notifyCount = notifyCount;
	}
	public Integer getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGeographic() {
		return geographic;
	}
	public void setGeographic(String geographic) {
		this.geographic = geographic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
