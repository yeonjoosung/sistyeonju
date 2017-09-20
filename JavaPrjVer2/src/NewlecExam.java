import opp.interf.AvgListener;
import opp.interf.Exam;

public class NewlecExam extends Exam implements AvgListener {
	private int com;

	public NewlecExam() {
		this(0, 0, 0, 0);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(0, 0, 0);
		this.setCom(com);
		// AvgListener a = new AvgListener() {
		//
		// public float avg() {
		// return total() + 11;
		// }
		// };
		//
		// setAvgListener(a);

		// setAvgListener(new AvgListener() {
		// public float avg() {
		// return total() / 4.0f;
		// }
		// });

		setAvgListener(() -> {return total() / 4.0f;});//람다식-함수가하나인인터페이스만이런식으로사용

	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;

	}

	@Override
	public int total() {
		return super.total() + com;
	}

	// public float avg() {
	// return 3;
	// }

	// public class AAA implements AvgListener {
	//
	// public float avg() {
	// return 11;
	//
	// }
	// }

}
