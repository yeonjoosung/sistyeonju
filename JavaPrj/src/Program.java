
public class Program {
	public static void main(String[] args) {
		Integer x = 3;
		Object y = 4;

		new Integer(3).intValue();

		// int a = 3.intValue(); //����

		String s = new String("hello");
		s = "hello";
		System.out.println(new String("hello").length());

		// String c = "hello".length();
		String k = "hello" + 3;
		System.out.println(k);

		int aa = 3;

		// String xx = Integer.toString(aa);

		String sss = String.valueOf(aa);

		double d = 3.4;
		String ad = Double.toString(d);

		double b = Double.parseDouble(ad);

		String name1 = "������";
		String name2 = new String("������");

		System.out.println(name1 == name2);// �ּҺ� , ���ڰ��� �񱳰��ƴ�

		String str = "hello";
		String s2 = str.replace("l", "g");
		System.out.println(str);
		System.out.println();
		System.out.println(s2);

		str = str.replace("l", "g");

		String str1 = "photo.jpg";

		System.out.println(str1.length());
		System.out.println(str1.indexOf("."));
		System.out.println(str1.substring(0, str1.indexOf(".")));

		String str2 = "��ȣ��, ���缮, �ŵ���, �輺��";

		String[] names = str2.split(", ");

		System.out.println(names[1]);

	}

}
