package oop.collec.col;


public class Exam {
	
	private int kor;
	private int eng;
	private int math;
	
	public Exam( ) {
		
		this(1,1,1);
		
	}
	public Exam(int kor, int eng, int math) {
		
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	
	}
	
	public int total() {
		
		return kor + eng + math;
		
	}
	
    public float avg() {
    	
		return total() / 3;
		
	}
    
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}



