package com.mb2217.entity;

public class Timing {
	private int t_id;
	private int f_id;
	private int c_id;
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	private String mh_id;
	private String t_start;
	private String t_end;
	private String mh_name;
	private String f_name;
	private double t_price;
	
	

	public double getT_price() {
		return t_price;
	}

	public void setT_price(double f_price) {
		this.t_price = f_price;
	}

	public String getMh_name() {
		return mh_name;
	}

	public void setMh_name(String mh_name) {
		this.mh_name = mh_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getMh_id() {
		return mh_id;
	}

	public void setMh_id(String mh_id) {
		this.mh_id = mh_id;
	}

	public String getT_start() {
		return t_start;
	}

	public void setT_start(String t_start) {
		this.t_start = t_start;
	}

	public String getT_end() {
		return t_end;
	}

	public void setT_end(String t_end) {
		this.t_end = t_end;
	}

}
