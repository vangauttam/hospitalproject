package com.alpha.hospital.dto;

public class PatientDto {
	private String name;
	private int age;
	private String disease;
	@Override
	public String toString() {
		return "patientDto [name=" + name + ", age=" + age + ", disease=" + disease + "]";
	}
	public String getName() {
		return name;
	}
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(String name, int age, String disease) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}

}
