package com.dgit.domain;



public class StudentInfo {
	private String name;
	private int grade;
	private int math;
	private int eng;
	private int kor;
	private Report report;
	
	
	
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getInfo(){
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("수학 : " + math);
		System.out.println("영어 : " + eng);
		System.out.println("국어 : " + kor);
		if(report !=null){
			return report.reportGrade(kor, eng, math);
		}
		return -1;
		
		
		
	}
	
	
	
}
