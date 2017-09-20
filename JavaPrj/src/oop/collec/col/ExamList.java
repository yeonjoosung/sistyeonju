package oop.collec.col;

public class ExamList {

	private Exam[] exams;
	private int index;
	private int capa;

	public ExamList() {

		exams = new Exam[3];
		index = 0;
		capa = 3;
	}

	public void add(Exam exam) {

		if (index >= capa) {
			Exam[] temp = new Exam[capa + 2];
			for (int i = 0; i < exams.length; i++) {
				temp[i] = exams[i];
			}
			exams = temp;

			capa += 2;

		}
		exams[index++] = exam;

	}

	public Exam get(int i) {

		return exams[i];
	}

	public int size() {
		return index;
	}

}
