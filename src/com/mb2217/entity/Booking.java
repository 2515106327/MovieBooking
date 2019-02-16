package com.mb2217.entity;

public class Booking {
	private int b_id;
	private int t_id;
	private int s_id;
	private int u_id;
	private String b_date;
	private double b_paym;
	
	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public double getB_paym() {
		return b_paym;
	}

	public void setB_paym(double b_paym) {
		this.b_paym = b_paym;
	}

	@Override
	public String toString() {
		return "Booking [b_id=" + b_id + ", t_id=" + t_id + ", s_id=" + s_id + ", u_id=" + u_id + ", b_date=" + b_date
				+ ", b_paym=" + b_paym + "]";
	}
}
