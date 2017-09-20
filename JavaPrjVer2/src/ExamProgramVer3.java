
public class ExamProgramVer3 {
	public static void main(String[] args) {
		
		NewlecExam exam = new NewlecExam();
//		NewlecExam.AAA aaa = exam.new AAA(); //내부클래스 생성방법
//		exam.setAvgListener(exam);//()안에 인터페이스 객체를 넣음, exam.은 내가만든것
		System.out.println(exam.avg());

	}

}
