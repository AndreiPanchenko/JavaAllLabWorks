package ru.panchenko.main;

/**
 * Класс для полиморфного суммирования чисел разных типов (наследников Number).
 */
public class SumCalculator {

  /**
   * Вычисляет сумму произвольного количества чисел.
   * @param numbers массив чисел (подтипов Number)
   * @return сумма всех чисел, приведённых к double
   */
  public static double Sum(Number... numbers) {
    double result = 0.0;
    for (Number num : numbers) {
      result += num.doubleValue();
    }
    return result;
  }
}