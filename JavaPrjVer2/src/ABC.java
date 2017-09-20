import opp.interf.AvgListener;

public class ABC implements AvgListener {
	
	
	private NewlecExam exam;

	public ABC (NewlecExam exam) {
		this.exam =exam;
		
	}//오버로드 생성자
	
	public float avg() {
		return exam.total()/4.0f;
	}


}
