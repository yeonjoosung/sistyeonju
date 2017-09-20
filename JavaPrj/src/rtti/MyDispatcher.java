package rtti;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyDispatcher {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		Class<?> cls = Class.forName("rtti.MyClass");
		MyClass myClass = (MyClass) cls.newInstance();
		Class<?>[] noparams = {};

		Method[] methods = myClass.getClass().getDeclaredMethods();
		// myClass.print();

		// System.out.println(methods.length);
		for (Method m : methods) {
			System.out.println("Method name : " + m.getName());

			if (m.isAnnotationPresent(Print.class)) {//print ������̼��� ������ �޼ҵ�
				// System.out.println("yes");
				Annotation ano = m.getAnnotation(Print.class);
				Print printAno = (Print) ano;

				if (printAno.enable()) {
					//������̼��� enable �Ӽ��� true�� �޼ҵ常 ȣ��
					Method method = cls.getDeclaredMethod(m.getName(), noparams);
					method.invoke(myClass);
				}
			}

			/*
			 * if (m.getName().equals("aaa")) { for (Parameter p : m.getParameters()) {
			 * String ptype = p.getParameterizedType().getTypeName();
			 * System.out.println("aaa() parameter name: " + p.getName());
			 * System.out.println(p.isNamePresent());
			 * System.out.println("aaa() parameter type: " + ptype);
			 * 
			 * Object param = Class.forName(ptype).newInstance(); //
			 * myClass.aaa((Exam)param); }
			 * 
			 * }
			 */

		}

	}

}
