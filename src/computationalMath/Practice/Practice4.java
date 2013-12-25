package computationalMath.Practice;

public class Practice4 {
	static final double	eps	= 0.0001;

	// TODO Реализовать проверку сходимости.
	public void calculateSimpleIteration() {
		int counter = 0;
		double x = 3; // начальное приближение
		double y = 1;
		double xPrev = 0;
		double yPrev = 0;

		if (!checkConv(x, y)) {
			System.out.println("\nДостаточное условие сходимости не прошло. Выходим из программы вычисления...\n");
		}

		while (Math.abs(x - xPrev) >= eps) {
			counter++;
			xPrev = x;
			yPrev = y;
			x = getFunction1(yPrev);
			y = getFunction2(xPrev);
		}
//		System.out.printf("Методом простых операциях: x: %.6f y: %.6f\n", x, getYFromFunction(x));
		System.out.printf("Методом простых операциях: x: %.6f y: %.6f\n", x, y);
		System.out.println("Итераций: " + counter);
		System.out.printf("Проверка по x %.4f = %.4f\n", getFunction1(y), x);
		System.out.printf("Проверка по y %.4f = %.4f\n\n", getFunction2(x), y);
	}

	/** Возврат одной функции, выраженной из Системы уравнений */
	public double getFunction(double x) {
		return 3 + Math.cos(0.5 - Math.cos(x - 1));
	}
	
	//Вернуть x
	public double getFunction1(double y) {
		return 3+Math.cos(y);
	}
	//Вернуть y
	public double getFunction2(double x) {
		return 0.5 - Math.cos(x-1);
	}
	
	public double getYFromFunction(double x) {
		return 0.5 - Math.cos(x - 1);
	}

	/** Проверка достаточного условия сходимости при начальном приближении x, y */
	public boolean checkConv(double x, double y) {
		if ((Math.sin(x - 1)) > 1)
			return false;
		if ((-Math.sin(y)) > 1)
			return false;

		return true;
	}

	public Practice4() {
		System.out.println("\nСистема уравнений:\ncos(x-1) + y = 0.5;\nx-cos(y) = 3;");
		System.out.println("Точность: " + eps);
	}

}
