package computationalMath.Practice;

/**
 * Наша задача - при данной СЛАУ, решить ее при помощи метода Гаусса. Программа должна вывести все корни уравнений.
 */
public class Practice1 {
	// Значения СЛАУ моего варианта
	private double[][]	aDef	= { { 2, 1, 0, 0, 0, 1 }, { 1, 3, 1, 0, 0, 2 }, { 0, 1, 4, 2, 0, -1 }, { 0, 0, 2, 5, 2, 0 }, { 0, 0, 0, 2, 1, 3 }, };
	private double[][]	aCheck	= { { 2, 1, 0, 0, 0, 1 }, { 1, 3, 1, 0, 0, 2 }, { 0, 1, 4, 2, 0, -1 }, { 0, 0, 2, 5, 2, 0 }, { 0, 0, 0, 2, 1, 3 }, };
	private double	a[][];
	private double	x[];

	/**
	 * Метод для вычисления решения по методу Гаусса. Пользуемся самым простым способом.
	 */
	public void calculate() {
		calculateArray();

		// Начальное значение x - коофициэнт после знака равно в СЛАУ (Уже упрощенной по Гауссу)
		x = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			x[i] = a[i][a.length];
		}

		for (int i = x.length - 1; i >= 0; i--) {
			// высчитываем коофициэнт последнего столбица, начинаем с конца
			for (int j = i + 1; j < a.length; j++) {
				x[i] += -a[i][j] * x[j];
			}
		}
	}

	/**
	 * Вычисляет верхний треугольник в матрице по методу Гаусса. Делает главную диагональ из единичек
	 */
	public void calculateArray() {
		int N = a.length;

		// TODO Сделать проверку на 0 опорных элементов
		// Делим всю линию на опорный элемент.
		// k - Текущая итерация алгоритма (Нужна для опр. с какого номера опорного элемента и столбца начинать)
		for (int k = 0; k < N; k++) {
			for (int i = N; i >= k; i--) {
				a[k][i] /= a[k][k];
			}

			// Получаем ноль в остальных строках под опорным элементом
			for (int i = k + 1; i < N; i++) {
				double tmp = a[i][k]; // Если tmp = 0, можно пропустить
				for (int j = k; j < N + 1; j++) {
					a[i][j] -= tmp * a[k][j];
				}
			}
		}
	}

	public void checkSolution() {
		System.out.println("Проверка решений (возможны погрешности из за отбрасывания дробной части");
		for (int i = 0; i < aCheck.length; i++) {
			for (int j = 0; j <= aCheck.length; j++) {
				if (j < a.length) {
					if (x[j] != 0 && aCheck[i][j] != 0) {
						System.out.print((int)(aCheck[i][j] * x[j]) + " + ");
					}
				}
				else {
					System.out.println(" = " + (int)aCheck[i][j]);
				}
			}
		}
	}

	public void init() {
		// TODO Инициализация любой пользовательской СЛАУ
	}

	public void initDefault() {
		a = new double[5][6];
		a = aDef;
	}

	public void printArray() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length + 1; j++) {
				System.out.print((int) a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printAnswer() {
		System.out.println("Корнями уравнений СЛАУ являются: ");
		for (int i = 0; i < x.length; i++) {
			// System.out.println("x" + (i+1) + " = " + x[i]);
			System.out.printf("x%d = %.3f\n", i + 1, x[i]);
		}
	}

	public Practice1() {
		System.out.println("Pratice 1 init...");
		initDefault();
		// int a[][] = { { 2, 1, 0, 0, 0, 1 }, { 1, 3, 1, 0, 0, 2 }, { 0, 1, 4, 2, 0, -1 }, { 0, 0, 2, 5, 2, 0 }, { 0,
		// 0, 0, 2, 1, 3 }, };
	}

	public Practice1(int N) {
		a = new double[N][N + 1];
	}
}