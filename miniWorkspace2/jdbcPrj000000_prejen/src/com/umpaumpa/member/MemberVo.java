package com.umpaumpa.member;

public class MemberVo {
	
	
	
	public MemberVo(String id, String pwd, String pwd2, String name, String nick, String weight, String gender,
			String no) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.nick = nick;
		this.weight = weight;
		this.gender = gender;
		this.no = no;
	}
	
	
	public MemberVo() {
		super();
	}


	private String id;
	private String pwd;
	private String pwd2;
	private String name;
	private String nick;
	private String weight;
	private String gender;
	private String no;
	public String getId() {
		return id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getPwd2() {
		return pwd2;
	}


	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
}
