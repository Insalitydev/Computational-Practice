package computationalMath;

import computationalMath.Practice.*;

public class Main {
	// Какие лабораторные запускаем
	private static boolean	Practice1	= false;
	private static boolean	Practice2	= true;
	private static boolean	Practice3	= false;
	private static boolean	Practice4	= false;
	private static boolean	Practice5	= true;
	private static boolean	Practice6	= false;
	private static boolean	Practice7	= false;

	public static void main(String[] args) {
		System.out.println("Лабораторные работы по вычислительным методам:");
		if (Practice1) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №1. Метод Гаусса");
			// Вызов методов первой лабораторной.
			Practice1 practice1 = new Practice1();
			practice1.printArray();
			practice1.calculate();
			practice1.printAnswer();
			practice1.checkSolution();
			System.out.println("Завершение лабораторной работы №1");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice2) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №2. Итерационные методы решения систем линейных уравнений");
			// Вызов методов второй лабораторной.
			Practice2 practice2 = new Practice2();
			practice2.printArray();
			if (practice2.calculate()) {
				practice2.checkSolution();
			}
			System.out.println("Завершение лабораторной работы №2");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice3) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №3. Решение нелинейных уравнений.");
			// TODO Вызов методов третьей лабораторной.
			Practice3 practice3 = new Practice3();
			practice3.calculateHalfDiv();
			System.out.println();
			practice3.calculateSimpleIteration();
			System.out.println("Завершение лабораторной работы №3");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice4) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №4");
			// TODO Вызов методов четвертой лабораторной.
			Practice4 practice4 = new Practice4();
			practice4.calculateSimpleIteration();
			System.out.println("Завершение лабораторной работы №4");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice5) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №5. Интерполирование алгебраическими многочленами.");
			Practice5 practice5 = new Practice5();
			practice5.calculate();
			System.out.println("Завершение лабораторной работы №5");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice6) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №6. Интерполирование сплайнами.");
			// TODO Вызов методов шестой лабораторной.
			System.out.println("Завершение лабораторной работы №6");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}

		if (Practice7) {
			System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Лабораторная работа №7. Численное интегрирование.");
			// TODO Вызов методов седьмой лабораторной.
			Practice7 practice7 = new Practice7();
			practice7.calculate();
			System.out.println("Завершение лабораторной работы №7");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		}
	}
}
