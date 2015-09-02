package com.example.tests;

public class Smpl_1 {

	public static void main(String[] args) {
		String a = new String("test");
		String b = new String("test");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		
		System.out.println(" 1 *************");
		String c = "test";
		String d = "test";
		System.out.println(c == d);
		System.out.println(c.equals(d));
		
		System.out.println(" 2 *************");
		String c1 = "2test";
		String d1 = "24532testtest";
		System.out.println(d1.contains(c1));
		System.out.println(d1.indexOf(c1));
		
		System.out.println(" 3 *************");
		String e = "test     test           test";
		String [] list = e.split("\\s+");
		System.out.println("world count = " + list.length);
		System.out.println(list[0]);
		System.out.println(list[1]);
		//System.out.println(list[2]);
		
		System.out.println(" 4 *************");
		String f = "test     test           test";
	    boolean list_1 = f.matches("(\\w+\\s+)+");
		System.out.println(list_1);
		
		System.out.println(" 5 *************");
		String f1 = "+7 (916) 123-45-67";
		// \\d означає, що є одна або більше цифр; \\s* означає, що є нуль або більше символів 
		System.out.println(f1.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));
		
		System.out.println(" 6 *************");
		String f2 = "+7 (916) 123-45-67";
		//нас не цікавлять мінуси і пробіли, то ми спочатку стрічку переведемо в інший вигляд
		//тобто замінимо пустою стрічкою всі лишні для нас символи: пробіл, дужку відкриту, дужку закриту та мінус
		//в квадратних дужках потрібно перечислити всі символи, які ми хочемо замінити, перед знаком мінус повинні бути два слеші 
		f2 = f2.replaceAll("[ ()\\-]", "");
		System.out.println(f2);
		System.out.println(f2.matches("\\+\\d+"));
		
		System.out.println(" 7 *************");
		String f3 = "+7 (916) 123-45-67";
		//для обрізання пробілів на Початку і в Кінці без заміни на інші символи є проста функція trim
		f3 = f3.trim();
		System.out.println(f3);
		System.out.println("@@@@@@@@@@@@@@@@@");
		f3 = f3.replaceAll("[ ()\\-]", "");
		System.out.println(f3);
		System.out.println(f3.matches("\\+\\d+"));
	}

}
