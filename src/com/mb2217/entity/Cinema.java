package com.mb2217.entity;

public class Cinema {
	private int c_id;
	private int a_id;
	private String c_adr;
	private String c_name;
	private String a_name;

	private int c_num;
	private String c_tel;
	private int mov_id;
	public int getMov_id() {
		return mov_id;
	}

	public void setMov_id(int mov_id) {
		this.mov_id = mov_id;
	}

	private String mov_name;
	
	
	public String getMov_name() {
		return mov_name;
	}

	public void setMov_name(String mov_name) {
		this.mov_name = mov_name;
	}

	private int f_id;
	public int getF_id() {
		return f_id;
	}

	public String getA_name() {
		return a_name;
	}
	
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}


	
	

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getC_adr() {
		return c_adr;
	}

	public void setC_adr(String c_adr) {
		this.c_adr = c_adr;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_tel() {
		return c_tel;
	}

	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	@Override
	public String toString() {
		return "Cinema [c_id=" + c_id + ", a_id=" + a_id + ", c_adr=" + c_adr + ", c_name=" + c_name + ", a_name="
				+ a_name + ", c_num=" + c_num + ", c_tel=" + c_tel + ", mov_id=" + mov_id + ", mov_name=" + mov_name
				+ ", f_id=" + f_id + "]";
	}


}
