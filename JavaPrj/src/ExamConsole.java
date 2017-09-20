
import java.util.Scanner;

public class ExamConsole {

	private Exam[] exams = new Exam[3];
	public ExamConsole() {
		exams[0] = new Exam();
		exams[1] = new Exam();
		exams[2] = new Exam();
		index = 0;
	}
	public ExamConsole(Exam[] exams) {
		exams[0] = new Exam();
		exams[1] = new Exam();
		exams[2] = new Exam();
		index = 0;
	}
	

	// private Exam exam = new Exam(); // 일체형
	private int index;

	/*
	 * public ExamConsole(Exam exam) { this.exam = exam; } 생성자를 통해 조립 - 이 방법은 한 번만
	 * 호출되므로 부품을 바꿔낄 수 가 없다. constructor를 통해 DI
	 */

//	public void setExam(Exam exam) {
//		this.exam = exam;
//	} // setter를 통해 DI(부품을 결합), 이 방법을 이용하면 필요할 때마다 호출 가능

	/*
	 * public ExamConsole() { exam = new Exam(); //이제 객체가 만들어짐. } // 기본 생성자
	 */
	// 클래스 영역에는 연산이 오면 안된다.

	public void input() {

		int kor = 0;
		int eng = 0;
		int math = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("┌───────────────────┐");
		System.out.println("│                         성적입력                       │");
		System.out.println("└───────────────────┘");
		for(int i=0;i<index;i++) {
		do {

			if (kor < 0 || kor > 100)
				System.out.println("성적의 범위(0~100)를 벗어났습니다. 다시 입력하세요.");
			System.out.println("국어: ");
			kor = scan.nextInt();
		} while (kor < 0 || kor > 100);

		do {
			if (eng < 0 || eng > 100)
				System.out.println("성적의 범위(0~100)를 벗어났습니다. 다시 입력하세요.");
			System.out.println("영어: ");
			eng = scan.nextInt();
		} while (eng < 0 || eng > 100);

		do {
			if (math < 0 || math > 100)
				System.out.println("성적의 범위(0~100)를 벗어났습니다. 다시 입력하세요.");
			System.out.println("수학: ");
			math = scan.nextInt();
		} while (math < 0 || math > 100);

		Exam exam = new Exam();
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);

		exams[index++] = exam;
		}
	}

	public void print() {

		for (int i = 0; i < index; i++) {
			Exam exam = exams[i];

			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();

			int total = 0;
			float avg;

			total = exam.total();
			avg = exam.avg();

			System.out.println("┌───────────────────┐");
			System.out.println("│                         성적출력                       │");
			System.out.println("└───────────────────┘");

			System.out.printf("국어%d: %d점\n", i + 1, kor);
			System.out.printf("영어%d: %d점\n", i + 1, eng);
			System.out.printf("수학%d: %d점\n", i + 1, math);
			System.out.printf("총점%d: %d점\n", i + 1, total);
			System.out.printf("평균%d: %.2f점\n", i + 1, avg);
		}

	}

}
