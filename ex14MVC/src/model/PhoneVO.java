package model;

public class PhoneVO {
	//Value Object - 테이블과 1대1매칭 
	//DB 컬럼들과 1대1매칭 - 필드 
	private String name;
	private String phoneNum;
	private int age;
	
	public PhoneVO() {
		super();
	}

	public PhoneVO(String name, String phoneNum, int age) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
