package com.mb2217.entity;

public class Seat {
	private int s_id;
	private String mh_id;
	private String s_xid;
	private String s_yid;
	private String mh_name;
	public String getMh_name() {
		return mh_name;
	}
	public void setMh_name(String mh_name) {
		this.mh_name = mh_name;
	}
	private boolean s_op;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getMh_id() {
		return mh_id;
	}
	public void setMh_id(String mh_id) {
		this.mh_id = mh_id;
	}
	public String getS_xid() {
		return s_xid;
	}
	public void setS_xid(String s_xid) {
		this.s_xid = s_xid;
	}
	public String getS_yid() {
		return s_yid;
	}
	public void setS_yid(String s_yid) {
		this.s_yid = s_yid;
	}
	public boolean isS_op() {
		return s_op;
	}
	public void setS_op(boolean s_op) {
		this.s_op = s_op;
	}
	
}
