package ru.panchenko.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Класс для возведения в степень на основе строковых аргументов.
 */
public class PowerCalculator {

  /**
   * Вычисляет x^y из строковых представлений целых чисел.
   * @param xStr строковое представление основания
   * @param yStr строковое представление показателя степени
   * @return результат возведения в степень
   * @throws IllegalArgumentException если аргументы не являются целыми числами
   */
  public static double CalculatePower(String xStr, String yStr) {
    try {
      int x = parseInt(xStr);
      int y = parseInt(yStr);
      return pow(x, y);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "Некорректные параметры: '" + xStr + "', '" + yStr + "'", e
      );
    }
  }
}