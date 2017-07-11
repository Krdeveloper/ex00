package com.dgit.domain;

public class BMICalculator {
	private double normal = 23.0;
	private double overWeight = 25.0;
	private double lowWeight = 18.0;
	private double obesity = 30.0; //비만
	
	
	
	
	public String getBMI(double weight, double height) {
		double h = height * 0.01;
		double result = weight /(h*h);
		
		System.out.println("BMI 지수 : " + (int) result);
		
		if(result >obesity){
			System.out.println("비만입니다.");
			return "비만";
		}else if(result> overWeight){
			System.out.println("과체중입니다.");
			return "과체중";
		}else if(result > normal){
			System.out.println("정상");
			return "정상";
		}else{
			System.out.println("저체중");
			return "저체중";
		}
	}
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOverWeight() {
		return overWeight;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public double getLowWeight() {
		return lowWeight;
	}
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	
}
