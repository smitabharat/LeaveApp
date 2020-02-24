package com.hefshine.bean;

import java.io.Serializable;

public class User implements Serializable 
{
private int uid;
private String uname;
private String password;
private String role;
private String status;
public User() {
	super();
}
public User(int uid, String uname, String password, String role, String status) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.password = password;
	this.role = role;
	this.status = status;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", role=" + role + ", status=" + status
			+ "]";
}



}
