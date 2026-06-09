package ru.panchenko.main;

import java.util.Scanner;

/**
 * Класс для безопасного ввода данных с обработкой ошибок.
 * Все методы статические.
 */
public class InputChecker {
  private static final Scanner kScanner = new Scanner(System.in);

  /**
   * Считывает целое число из стандартного ввода.
   * @return введённое целое число
   */
  public static int GetInt() {
    while (true) {
      try {
        return Integer.parseInt(kScanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите целое число: ");
      }
    }
  }

  /**
   * Считывает вещественное число из стандартного ввода.
   * @return введённое число
   */
  public static double GetDouble() {
    while (true) {
      try {
        return Double.parseDouble(kScanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите число: ");
      }
    }
  }

  /**
   * Считывает положительное вещественное число.
   * @return положительное число (>0)
   */
  public static double GetPositiveDouble() {
    while (true) {
      try {
        double value = Double.parseDouble(kScanner.nextLine().trim());
        if (value <= 0) {
          System.out.print("Ошибка! Введите положительное число: ");
          continue;
        }
        return value;
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите число: ");
      }
    }
  }

  /**
   * Считывает целое число в заданном диапазоне.
   * @param min минимальное допустимое значение (включительно)
   * @param max максимальное допустимое значение (включительно)
   * @return введённое число
   */
  public static int GetIntInRange(int min, int max) {
    while (true) {
      try {
        int value = Integer.parseInt(kScanner.nextLine().trim());
        if (value < min || value > max) {
          System.out.print("Ошибка! Введите число от " + min + " до " + max + ": ");
          continue;
        }
        return value;
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите целое число: ");
      }
    }
  }

  /**
   * Считывает непустую строку (после trim).
   * @return непустая строка
   */
  public static String GetString() {
    return kScanner.nextLine().trim();
  }

  /**
   * Считывает непустую строку.
   * @return непустая строка
   */
  public static String GetNonEmptyString() {
    while (true) {
      String input = kScanner.nextLine().trim();
      if (input.isEmpty()) {
        System.out.print("Ошибка! Введите непустую строку: ");
        continue;
      }
      return input;
    }
  }

  // Перегруженные методы с подсказкой

  /**
   * Считывает целое число с предварительным выводом подсказки.
   * @param prompt текст подсказки
   * @return целое число
   */
  public static int GetInt(String prompt) {
    System.out.print(prompt);
    return GetInt();
  }

  /**
   * Считывает вещественное число с предварительным выводом подсказки.
   * @param prompt текст подсказки
   * @return число
   */
  public static double GetDouble(String prompt) {
    System.out.print(prompt);
    return GetDouble();
  }

  /**
   * Считывает положительное число с подсказкой.
   * @param prompt текст подсказки
   * @return положительное число
   */
  public static double GetPositiveDouble(String prompt) {
    System.out.print(prompt);
    return GetPositiveDouble();
  }

  /**
   * Считывает целое число в диапазоне с подсказкой.
   * @param prompt текст подсказки
   * @param min минимум
   * @param max максимум
   * @return число в диапазоне
   */
  public static int GetIntInRange(String prompt, int min, int max) {
    System.out.print(prompt);
    return GetIntInRange(min, max);
  }

  /**
   * Считывает строку с подсказкой.
   * @param prompt текст подсказки
   * @return строка (может быть пустой)
   */
  public static String GetString(String prompt) {
    System.out.print(prompt);
    return GetString();
  }

  /**
   * Считывает непустую строку с подсказкой.
   * @param prompt текст подсказки
   * @return непустая строка
   */
  public static String GetNonEmptyString(String prompt) {
    System.out.print(prompt);
    return GetNonEmptyString();
  }
}