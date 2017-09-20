package oop.collec.col;

public class ObjectList {

	private Object[] list;
	private int index;
	private int capa;

	public ObjectList() {

		list = new Object[3];
		index = 0;
		capa = 3;
	}

	public void add(Object exam) {

		if (index >= capa) {
			Object[] temp = new Exam[capa + 2];
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			list = temp;

			capa += 2;

		}
		list[index++] = exam;

	}

	public Object get(int i) {

		return list[i];
	}

	public int size() {
		return index;
	}

}
