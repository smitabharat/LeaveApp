package com.hefshine.bean;

public class Task 
{
	
	private int tid;
	private int uid;
	private String currentdate; 
	private String submitdate;
	private String status;
	private String task;
	private int managerid;

	
	public Task() {
		// TODO Auto-generated constructor stub
	}


	public Task(int tid, int uid, String currentdate, String submitdate, String status, String task, int managerid) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.currentdate = currentdate;
		this.submitdate = submitdate;
		this.status = status;
		this.task = task;
		this.managerid = managerid;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getCurrentdate() {
		return currentdate;
	}


	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}


	public String getSubmitdate() {
		return submitdate;
	}


	public void setSubmitdate(String submitdate) {
		this.submitdate = submitdate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public int getManagerid() {
		return managerid;
	}


	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}


	@Override
	public String toString() {
		return "Task [tid=" + tid + ", uid=" + uid + ", currentdate=" + currentdate + ", submitdate=" + submitdate
				+ ", status=" + status + ", task=" + task + ", managerid=" + managerid + "]";
	}
}