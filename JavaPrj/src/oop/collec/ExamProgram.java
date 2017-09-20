package oop.collec;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {
		
//		 Exam exam = new Exam();
		
		ExamConsole console = new ExamConsole();
		 // 외부에서 조립 x, Composition has a 관계 - 일체형
		
	    // console.setExam(exam);  조립형을 사용할 경우
	
		int menu;
		
		EXIT:
		while(true) {
			//1. 메인메뉴 입력
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
			    	System.out.println("메뉴를 다시 선택하세요!!");
		    					    		
			}
		}
		
	}

	public static int inputMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		 System.out.println("┌───────────────────┐");
		 System.out.println("│                         메인메뉴                       │");
		 System.out.println("└───────────────────┘");
		 System.out.println("1.성적입력");
		 System.out.println("2.성적출력");
		 System.out.println("3.종료");
		 System.out.println("메뉴 선택 > ");
		 
		int menu = scan.nextInt();
		
		return menu;
			
	} // 객체를 사용하지 않으므로 static을 지울 필요가 없다.

}


