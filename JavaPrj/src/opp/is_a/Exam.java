package opp.is_a;

public class Exam {

	private int kor;
	private int eng;
	private int math;
	

	public Exam() {
		// kor = 1;
		// eng = 1;
		// math = 1;
		this(0,0,0);
	}

	public Exam(int kor, int eng, int math) {
		this.setKor(kor);
		this.setEng(eng);
		this.setMath(math);
	}

	public float avg() {
		return total() / 3;
	}

	public int total() {
		return getKor() + getEng() + getMath();
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
