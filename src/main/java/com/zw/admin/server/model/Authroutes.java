package com.zw.admin.server.model;



public class Authroutes extends BaseEntity<Long> {

	private String name;
	private String path;
	private String AUTHORS;
	private Integer pid;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAUTHORS() {
		return AUTHORS;
	}
	public void setAUTHORS(String AUTHORS) {
		this.AUTHORS = AUTHORS;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}

}
