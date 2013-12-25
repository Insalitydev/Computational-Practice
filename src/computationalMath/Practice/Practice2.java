package computationalMath.Practice;

public class Practice2 {

	// Вариант СЛАУ №5 Уже с преобладанием главное диагонали
	private double[][]	aDef	= { { 2.3, 1.1, 0.23, 3.3 }, { 0.3, 2.4, 2., 2.6 }, { 0.2, 2.1, 2.5, 4.4 } };
	double[]			previousVariableValues;
	int					size	= aDef.length;

	/** Возвращает истину, если получилось посчитать. Ложь если нет, условие сходимости не было выполнено.*/
	public boolean calculate() {
		// Будем хранить матрицу в векторе, состоящем из
		// векторов вещественных чисел
		double[][] a = new double[size][size + 1];
		a = aDef;
		

		// Проверка условия сходимости
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum = 0;
			for (int j = 0; j < size; j++) {
				if (i != j) {
					sum += Math.abs(a[i][j] / a[i][i]);
				}
			}
			if (sum > 1) {
				System.out.println("Метод не удовлетворяет условию сходимости...");
				return false;
			}
			else {
				System.out.println("Норма " + (i + 1) + " строки = " + sum);
			}
		}

		double eps = 0.001;
		int iterCounter = 0;

		// Введем вектор значений неизвестных на предыдущей итерации,
		// Согласно методу изначально заполняем его нулями
		previousVariableValues = new double[size];
		for (int i = 0; i < size; i++) {
			previousVariableValues[i] = 0.0;
		}

		// Будем выполнять итерационный процесс до тех пор,
		// пока не будет достигнута необходимая точность
		while (true) {
			// Вектор значений неизвестных на текущем шаге
			double[] currentVariableValues = new double[size];

			// Посчитаем значения неизвестных на текущей итерации
			// в соответствии с теоретическими формулами
			for (int i = 0; i < size; i++) {
				// Инициализируем i-ую неизвестную значением
				// свободного члена i-ой строки матрицы
				currentVariableValues[i] = a[i][size];

				// Вычитаем сумму по всем отличным от i-ой неизвестным
				for (int j = 0; j < size; j++) {
					if (i != j) {
						currentVariableValues[i] -= a[i][j] * previousVariableValues[j];
					}
				}

				// Делим на коэффициент при i-ой неизвестной
				currentVariableValues[i] /= a[i][i];
			}

			// Погрешность
			double error = 0.0;

			for (int i = 0; i < size; i++) {
				error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
			}

			iterCounter++;

			if (error < eps) {
				break;
			}

			// Переходим к следующей итерации, так
			// что текущие значения неизвестных
			// становятся значениями на предыдущей итерации
			previousVariableValues = currentVariableValues;
		}

		// Выводим найденные значения неизвестных
		System.out.println("Шагов: " + iterCounter + "\nТочность: " + eps);

		System.out.println("Корни уравнения:");
		for (int i = 0; i < size; i++) {
			System.out.println("x" + (i + 1) + " = " + previousVariableValues[i]);
		}

		return true;
	}

	public void checkSolution() {
		System.out.println("\nПроверка решения:");

		for (int i = 0; i < aDef.length; i++) {
			for (int j = 0; j <= aDef.length; j++) {
				if (j != aDef.length)
					System.out.print((int) (previousVariableValues[j] * aDef[i][j]) + " + ");
				else
					System.out.println("= " + aDef[i][size]);
			}
		}
		System.out.println();
	}

	public void printArray() {
		for (int i = 0; i < aDef.length; i++) {
			for (int j = 0; j < aDef.length + 1; j++) {
				System.out.print(aDef[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
