package com.citiustech.model;

import java.util.List;

public class Student {

	private int id;
	private String name;
	private int standard;
	private String division;
	private String club;
	private boolean mathExam;
	private boolean scienceExam;
	private boolean englishExam;
	private List<String> exam;
	
	public Student(){
		
	}

	public Student(int id, String name, int standard, String division, String club, boolean mathExam, boolean scienceExam,
			boolean englishExam, List<String> exam) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.division = division;
		this.club = club;
		this.mathExam = mathExam;
		this.scienceExam = scienceExam;
		this.englishExam = englishExam;
		this.exam = exam;
	}
	
	

	public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public int getStandard() {
		return standard;
	}

	public String getDivision() {
		return division;
	}

	public String getClub() {
		return club;
	}

	public boolean isMathExam() {
		return mathExam;
	}

	public boolean isScienceExam() {
		return scienceExam;
	}

	public boolean isEnglishExam() {
		return englishExam;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public void setMathExam(boolean mathExam) {
		this.mathExam = mathExam;
	}

	public void setScienceExam(boolean scienceExam) {
		this.scienceExam = scienceExam;
	}

	public void setEnglishExam(boolean englishExam) {
		this.englishExam = englishExam;
	}
	

	public List<String> getExam() {
		return exam;
	}

	public void setExam(List<String> getSatusExam) {
		this.exam = getSatusExam;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standard=" + standard + ", division=" + division + ", club="
				+ club + ", mathExam=" + mathExam + ", scienceExam=" + scienceExam + ", englishExam=" + englishExam
				+ ", exam=" + exam + "]";
	}

}
