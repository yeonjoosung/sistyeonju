package com.newlecture.ems.ui;
/*Is a : ����, ��ǰX
 *����� =>extends Exam
 *  �������̵�
 *  this �Ļ�Ŭ����(�ڽ�Ŭ����)
 *  super :�ڽ��� ����̵Ǵ°� (�θ�Ŭ����)
 * 
 * 
 * private int com; // ��ǻ�Ͱ��� �߰�(Ȯ��)

	public NewlecExam() {
		this(0,0,0,0);
//		super();
//		this.com = 0;
	}

	// �����ε� ����� ��� �⺻�����ڸ� �����ؾ���.�ǵ������� �⺻�����ڸ� ���������� ������ ���ذ��Ϸ��� ��쵵����������
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

	public int total() { // =>�������̵�
		return super.total()+ com; // getKor()+getMath()+getEng()
	}// extends�Ͽ�� get����� ���غҷ���
	
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
