package computationalMath.Practice;

public class Practice3 {

	static final double	eps	= 0.0001;

	/** Вычисление вещественного корня с помощью метода деления отрезка пополам. Включает в себя вывод результата. */
	public void calculateHalfDiv() {
		// double aStart = -0.5;
		// double bStart = 0.5;
		double aStart = -0.4;
		double bStart = 0.3;
		double a = aStart;
		double b = bStart;
		int counter = 0;

		while ((b - a) > eps / 2) {
			counter++;
			double mid = (b + a) / 2;

			if (getFunction(a) * getFunction(mid) <= 0) {
				b = mid;
			}

			if (getFunction(mid) * getFunction(b) <= 0) {
				a = mid;
			}

		}

		System.out.printf("Найденный корень с помощью деления отрезков пополам = %.7f\n", (b + a) / 2.);
		System.out.println("Границы поиска: " + aStart + " : " + bStart);
		System.out.println("Итераций: " + counter);

		System.out.printf("Проверка: %.7f\n\n", getFunction((b + a) / 2));
	}

	public void calculateSimpleIteration() {
		int counter = 0;
		double x = 1.2;
		double xPrev = 0;
		while (Math.abs(x - xPrev) >= eps) {
			counter++;
			xPrev = x;
			x = getFunctionSI(xPrev);
		}
		System.out.println("Методом простых операциях: " + x);
		System.out.println("Итераций: " + counter);
		System.out.printf("Проверка %.6f = %.6f\n\n", getFunctionSI(x), x);
	}

	/** Возвращает функцию tg(x/3) * x^3 */
	public double getFunction(double x) {
		return (Math.tan(x / 3) - Math.pow(x, 3));
	}

	/** Функция для метода простых итераций. x = 3* arctg(x^3) */
	public double getFunctionSI(double x) {
		return (3 * Math.atan(Math.pow(x, 3)));
	}

	public Practice3() {
		System.out.println("\nФункция: tg(x/3) * x^3.");
		System.out.println("Точность: " + eps + ".\n");
	}
}