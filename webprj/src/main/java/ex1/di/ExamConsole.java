package ex1.di;

public class ExamConsole {
	
	private Exam exam;
	
	
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}



	public Exam getExam() {
		return exam;
	}



	public void print() {
		System.out.printf("total: %d, avg:%f\n",exam.total(),exam.avg());
		
	}
	
}
