package com.objectinfo;
public class DBInfo {
	private String dbtype;
	private String	port;
	private String	ip;
	private String	username;
	private String	password;
	private String	dbname;
	private boolean DBState;
	public boolean isDBState() {
		return DBState;
	}
	public void setDBState(boolean dBState) {
		DBState = dBState;
	}
	public String getDbtype() {
		return dbtype;
	}
	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}	
}
