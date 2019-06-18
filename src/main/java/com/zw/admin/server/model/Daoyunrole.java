package com.zw.admin.server.model;



public class Daoyunrole extends BaseEntity<Long> {

	private String note;
	private String uniqeKey;
	private String name;
	private String status;

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUniqeKey() {
		return uniqeKey;
	}
	public void setUniqeKey(String uniqeKey) {
		this.uniqeKey = uniqeKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
