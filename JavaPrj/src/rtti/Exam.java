package rtti;

public class Exam {
	
	private int kor;
	private int eng;
	private int math;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Exam(int kor, int eng, int math) {
		super();
		this.setKor(kor);
		this.setEng(eng);
		this.setMath(math);
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

	public int total() {
		// TODO Auto-generated method stub
		return kor+eng+math;
	}

	public float avg() {
		// TODO Auto-generated method stub
		return (float) ((kor+eng+math)/3.0);
	}
	
	
	

}
