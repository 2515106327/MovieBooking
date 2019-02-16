package com.mb2217.entity;

public class Movie_Hall {
private String mh_id;
private int c_id;
private int seat_number;
private String mh_name;

public Movie_Hall() {
	super();
}
public Movie_Hall(String mh_id, int c_id, int seat_number) {
	super();
	this.mh_id = mh_id;
	this.c_id = c_id;
	this.seat_number = seat_number;
	
}
public String getMh_id() {
	return mh_id;
}
public void setMh_id(String mh_id) {
	this.mh_id = mh_id;
}
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public int getSeat_number() {
	return seat_number;
}
public void setSeat_number(int seat_number) {
	this.seat_number = seat_number;
}
public String getMh_name() {
	return mh_name;
}
public void setMh_name(String mh_name) {
	this.mh_name = mh_name;
}
}
