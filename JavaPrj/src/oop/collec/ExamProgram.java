package oop.collec;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {
		
//		 Exam exam = new Exam();
		
		ExamConsole console = new ExamConsole();
		 // �ܺο��� ���� x, Composition has a ���� - ��ü��
		
	    // console.setExam(exam);  �������� ����� ���
	
		int menu;
		
		EXIT:
		while(true) {
			//1. ���θ޴� �Է�
			menu = inputMenu();
			
			switch(menu)
			{
				case 1:	
						console.input();
					    break;
				 
			    case 2:    		
			    		console.print();
			    		break;
			    
			    case 3:
			    		break EXIT;
			    		
			    default:
			    	System.out.println("�޴��� �ٽ� �����ϼ���!!");
		    					    		
			}
		}
		
	}

	public static int inputMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		 System.out.println("������������������������������������������");
		 System.out.println("��                         ���θ޴�                       ��");
		 System.out.println("������������������������������������������");
		 System.out.println("1.�����Է�");
		 System.out.println("2.�������");
		 System.out.println("3.����");
		 System.out.println("�޴� ���� > ");
		 
		int menu = scan.nextInt();
		
		return menu;
			
	} // ��ü�� ������� �����Ƿ� static�� ���� �ʿ䰡 ����.

}


