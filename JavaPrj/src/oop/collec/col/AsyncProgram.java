package oop.collec.col;

import java.util.ArrayList;
import java.util.Iterator;

import oop.collec.col.GenericList.Giterator;

public class AsyncProgram {

	public static void main(String[] args) {
		GenericList<Integer> list = new GenericList<Integer>();
		
		for (int i = 0; i < 100; i++)
			list.add(i + 1);
		// Thread th1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// download(list, 1);
		// }
		//
		// });
		// ���ٽ�
		 Thread th1 = new Thread(()->{download(list, 1);} );
		 th1.start();

//		new Thread(() -> {
//			download(list, 1);
//		}).start();

		download(list, 2);

		System.out.println("System End~");
	}

	private static void download(GenericList<Integer> list, int num) {
//		 for (int i = 0; i < 100; i++)
//		 System.out.printf("%d��°: %d%%\n", num, list.get(i));
		
//		iterator iter = list.iterator(); 
//		while (iter.hasNext())
//			System.out.printf("%d��°: %d%%\n", num, iter.next());
//		next()�Լ��� thread�� ������������=>current�� thread�� ����
//		thread���� current�� ����
		
		/*iterator�� �ڵ����� �ε����� ����*/
		for(Integer i : list)
			System.out.printf("%d��°: %d%%\n", num, i);
		
		
	}
	
	
	
	

}
