package com.newlecture.ems.ui;
/*Is a : 뼈대, 부품X
 *사용방법 =>extends Exam
 *  오버라이드
 *  this 파생클래스(자식클래스)
 *  super :자신의 기반이되는것 (부모클래스)
 * 
 * 
 * private int com; // 컴퓨터과목 추가(확장)

	public NewlecExam() {
		this(0,0,0,0);
//		super();
//		this.com = 0;
	}

	// 오버로드 만드는 경우 기본생성자를 생성해야함.의도적으로 기본생성자를 강제적으로 만들지 못해게하려는 경우도있을수있음
	public NewlecExam(int kor, int eng, int math, int com) {
		
		super(kor, eng, math);
		this.com = com;
		
		
	}

	// public NewlecExam(int kor, int eng, int math, int com) {
	// setKor(kor);
	// setEng(eng);
	// setMath(math);
	// this.com=com;
	// }

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	public int total() { // =>오버라이드
		return super.total()+ com; // getKor()+getMath()+getEng()
	}// extends하였어도 get방식을 통해불러옴
	
	public float avg() {
		return total() / 4.0f;
	}
 * */

//import opp.is_a.Exam;
import com.newlecture.ems.entity.*;


public class NewlecExam extends Exam {
	private int com;
	
	public NewlecExam() {
		this(0,0,0,0);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(0,0,0);
		this.setCom(com);
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
		
	}

	@Override
	public float avg() {
		return total()/4;
	}

	@Override
	public int total() {
		return super.total()+com;
	}
	
	

	

}
