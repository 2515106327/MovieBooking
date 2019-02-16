package com.mb2217.entity;

public class Movie_User {
private int mov_id;
private String mov_name;
private String mov_password;
private String c_name;


public String getC_name() {
	return c_name;
}
public void setC_name(String c_name) {
	this.c_name = c_name;
}
@Override
public String toString() {
	return "Movie_User [mov_id=" + mov_id + ", mov_name=" + mov_name + ", mov_password=" + mov_password + "]";
}
public int getMov_id() {
	return mov_id;
}
public void setMov_id(int mov_id) {
	this.mov_id = mov_id;
}
public String getMov_name() {
	return mov_name;
}
public void setMov_name(String mov_name) {
	this.mov_name = mov_name;
}
public String getMov_password() {
	return mov_password;
}
public void setMov_password(String mov_password) {
	this.mov_password = mov_password;
}

}
