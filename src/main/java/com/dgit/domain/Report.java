package com.dgit.domain;

public class Report {
	private double level1 = 91;
	private double level2 = 81;
	private double level3 = 71;
	private double level4 = 61;
	
	public int reportGrade(int kor, int eng, int math){
		double average = (kor+eng+math)/3;
		
		if(average > level1){
			System.out.println("1등급");
			return 1;
		}else if(average>level2){
			System.out.println("2등급");
			return 2;
		}else if(average>level3){
			System.out.println("3등급");
			return 3;
		}else{
			System.out.println("4등급");
			return 4;
		}
	}
	public double getLevel1() {
		return level1;
	}
	public void setLevel1(double level1) {
		this.level1 = level1;
	}
	public double getLevel2() {
		return level2;
	}
	public void setLevel2(double level2) {
		this.level2 = level2;
	}
	public double getLevel3() {
		return level3;
	}
	public void setLevel3(double level3) {
		this.level3 = level3;
	}
	public double getLevel4() {
		return level4;
	}
	public void setLevel4(double level4) {
		this.level4 = level4;
	}
	
	
}
