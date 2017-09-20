
public class Program {
	public static void main(String[] args) {
		Integer x = 3;
		Object y = 4;

		new Integer(3).intValue();

		// int a = 3.intValue(); //오류

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

		String name1 = "아이유";
		String name2 = new String("아이유");

		System.out.println(name1 == name2);// 주소비교 , 문자값의 비교가아님

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

		String str2 = "강호동, 유재석, 신동엽, 김성주";

		String[] names = str2.split(", ");

		System.out.println(names[1]);

	}

}
