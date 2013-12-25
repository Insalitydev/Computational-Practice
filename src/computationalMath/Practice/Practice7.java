package computationalMath.Practice;

public class Practice7 {

	public double	xFrom	= 0.6;
	public double	xTo		= 1.8;
	/** реальное значение интеграла */
	public double	real;
	/** Погрешность */
	public double	lose;
	/** Интервал отрезка */
	public double	range	= 0.0002;
	public double	count;

	public void calculate() {
		// Real += -(Math.log(Math.abs((Math.cos(xFrom)))) + (Math.log(Math.abs((Math.cos(xTo))))));
		real = 1.07008; // Посчитано через WolframAlpha
		System.out.println("Точное значение интеграла: " + real);

		// считаем приближенное значение интеграла
		for (double i = xFrom; i <= xTo-range; i += range) {
			count += Math.abs(getFunction(i));
		}
		count *= range;
		System.out.printf("Приближенное значение интеграла: %.6f", count);

		System.out.printf("\nПогрешность: %.6f\n\n", Math.abs(real - count));
	}

	public double getFunction(double x) {
		return (x * x) / (Math.sqrt(x + 1.7));
	}

	public Practice7() {
		System.out.println("\nИнтеграл: Int from 0.6 to 1.8: x^2 / (sqrt(x + 1.7)) dx");
		System.out.println("Интервал: " + range);
	}

}
