package ex1.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	
	public static void main(String[] args) {
		
	/*	Exam exam = new Exam(10,20,30);
		ExamConsole console = new ExamConsole();
		console.setExam(exam);*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1/di/config.xml");
		
			
		ExamConsole console = (ExamConsole) context.getBean("console");
		
		console.print();
		
	}

}
