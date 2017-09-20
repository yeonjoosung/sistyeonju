package ex1.di;

public class FantasticConsole extends ExamConsole{
	@Override
	public void print() {
		Exam exam = getExam();
		
		System.out.printf("Fantastic Total : [%d]",exam.total());
	}

}
