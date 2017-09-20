package oop.collec.col;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {

	private T[] list;
	private int index;
	private int capa;

	// private int current;
	public GenericList() {

		list = (T[]) new Object[3];
		index = 0;
		capa = 3;
		// current =-1;
	}

	// ---------- 데이터 수집 ------------------//
	public void add(T object) {

		if (index >= capa) {
			T[] temp = (T[]) new Object[capa + 2];
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			list = temp;

			capa += 2;

		}
		list[index++] = object;

	}

	public T get(int i) {

		return list[i];
	}

	public int size() {
		return index;
	}
	// ---------- 데이터 조회 ------------------//

	class Giterator implements Iterator<T>{
		private int current;

		public Giterator() {
			current = -1;
		}

		public boolean hasNext() {
			++current;
			return index > current;
		}

		public T next() {
			return list[current];
		}
	}

	public Giterator iterator() {
		return new Giterator();
	}

}
