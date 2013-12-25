package computationalMath.Practice;

public class Practice5 {

	private static final double	a[]	= { 2, 2.3, 2.5, 3.0, 3.5, 3.8, 4.0 };
	private static final double	b[]	= { 5.848, 6.127, 6.300, 6.694, 7.047, 7.243, 7.368 };
	/** Искомое x */
	private static final double	x	= 2.5001;

	public void calculate() {

		printArray();

		float wx = getFunc(x);
		float fx = 0;
		for (int n = 0; n < a.length; n++) {
			fx += (b[n] * wx) / ((getFuncDer(n)) * (x - a[n]));
		}

		System.out.println("Значение функции в точке " + x + " равно:" + fx + "\n");
	}

	/** Возвращает w(x) */
	private float getFunc(double x) {
		float result = 1;
		for (int i = 0; i < a.length; i++) {
			result *= x - a[i];
		}

		return result;
	}

	/** Возвращает w'(x). n - номер элемента, который не будет вычисляться. */
	private float getFuncDer(int n) {
		float result = 1;
		for (int i = 0; i < a.length; i++) {
			if (i != n)
				result *= a[n] - a[i];
		}
		return result;
	}

	private void printArray() {
		System.out.print("x:      ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "     ");
		}
		System.out.println();

		System.out.print("F(x): ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "  ");
		}
		System.out.println();
	}

	public Practice5() {
		System.out.println("Practice5 init...\n");
		System.out.println("Задание - вычислить в точке x = " + x + " значение функции");
		System.out.println("Вычисляем по формуле Лагранжа");
	}

}
