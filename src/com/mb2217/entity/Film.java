package com.mb2217.entity;

public class Film {
private int  f_id;
private String f_name;
private String f_director;
private String f_play;
private String f_intro;
private String f_language;
private int f_long;
private String f_date;
private String f_type;
private String f_avatar;
private int c_id;


public int getC_id() {
	return c_id;
}

public void setC_id(int c_id) {
	this.c_id = c_id;
}

public String getF_avatar() {
	return f_avatar;
}

public void setF_avatar(String f_avatar) {
	this.f_avatar = f_avatar;
}

public String getF_type() {
	return f_type;
}

public void setF_type(String f_type) {
	this.f_type = f_type;
}
private double f_price;
private int hot;
public Film(int f_id, String f_name, String f_director, String f_play, String f_intro, String f_language, int f_long,
		String f_date, double f_price, int hot) {
	super();
	this.f_id = f_id;
	this.f_name = f_name;
	this.f_director = f_director;
	this.f_play = f_play;
	this.f_intro = f_intro;
	this.f_language = f_language;
	this.f_long = f_long;
	this.f_date = f_date;
	this.f_price = f_price;
	this.hot = hot;
}

public int getHot() {
	return hot;
}

public void setHot(int hot) {
	this.hot = hot;
}

public int getF_id() {
	return f_id;
}

public Film() {
	super();
}

public void setF_id(int f_id) {
	this.f_id = f_id;
}
public String getF_name() {
	return f_name;
}
public void setF_name(String f_name) {
	this.f_name = f_name;
}
public String getF_director() {
	return f_director;
}
public void setF_director(String f_director) {
	this.f_director = f_director;
}
public String getF_play() {
	return f_play;
}
public void setF_play(String f_play) {
	this.f_play = f_play;
}
public String getF_intro() {
	return f_intro;
}
public void setF_intro(String f_intro) {
	this.f_intro = f_intro;
}
public String getF_language() {
	return f_language;
}
public void setF_language(String f_language) {
	this.f_language = f_language;
}
public int getF_long() {
	return f_long;
}
public void setF_long(int f_long) {
	this.f_long = f_long;
}
public String getF_date() {
	return f_date;
}
public void setF_date(String f_date) {
	this.f_date = f_date;
}
public double getF_price() {
	return f_price;
}
public void setF_price(double f_price) {
	this.f_price = f_price;
}

}
