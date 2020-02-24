package com.hefshine.bean;

import java.io.Serializable;

public class Leave implements Serializable
{
private int lid;
private int uid;
private String ltype;
private String applied_date;
private String fromdate;
private String todate;
private String status;
private String description ;
private String reason;


public Leave() {
	super();
}
public Leave(int lid, int uid, String ltype, String applied_date, String fromdate, String todate, String status,
		String description, String reason) {
	super();
	this.lid = lid;
	this.uid = uid;
	this.ltype = ltype;
	this.applied_date = applied_date;
	this.fromdate = fromdate;
	this.todate = todate;
	this.status = status;
	this.description = description;
	this.reason = reason;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getLtype() {
	return ltype;
}
public void setLtype(String ltype) {
	this.ltype = ltype;
}
public String getApplied_date() {
	return applied_date;
}
public void setApplied_date(String applied_date) {
	this.applied_date = applied_date;
}
public String getFromdate() {
	return fromdate;
}
public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
@Override
public String toString() {
	return "Leave [lid=" + lid + ", uid=" + uid + ", ltype=" + ltype + ", applied_date=" + applied_date + ", fromdate="
			+ fromdate + ", todate=" + todate + ", status=" + status + ", description=" + description + ", reason="
			+ reason + "]";
}


}
