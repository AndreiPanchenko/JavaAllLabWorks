package ru.panchenko.main;

import ru.panchenko.geometry.*;
import ru.panchenko.collections.ImmutableList;
import ru.panchenko.extended.*;
import java.util.Arrays;

/**
 * Главный класс программы, реализующий интерактивное меню и демонстрацию всех заданий.
 */
public class Main {

  /**
   * Обрабатывает аргументы командной строки (возведение в степень).
   * @param args аргументы командной строки
   */
  private static void HandleCommandLineArgs(String[] args) {
    try {
      double result = PowerCalculator.CalculatePower(args[0], args[1]);
      System.out.println("Результат возведения в степень: " +
          args[0] + " ^ " + args[1] + " = " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка при обработке аргументов командной строки: " + e.getMessage());
    }
    System.out.println();
  }

  /**
   * Запускает интерактивное меню выбора заданий.
   */
  private static void RunInteractiveMenu() {
    while (true) {
      PrintMenu();
      int choice = InputChecker.GetInt("Выберите задание: ");
      switch (choice) {
        case 1:
          DemonstrateLine();
          break;
        case 2:
          DemonstrateSquare();
          break;
        case 3:
          DemonstrateImmutableList();
          break;
        case 4:
          DemonstratePoint3D();
          break;
        case 5:
          DemonstrateExtendedPoints();
          break;
        case 6:
          DemonstrateSum();
          break;
        case 7:
          DemonstrateLineComparison();
          break;
        case 8:
          DemonstrateLineClone();
          break;
        case 0:
          System.out.println("Выход из программы. До свидания!");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
      System.out.println();
    }
  }

  /** Печатает главное меню. */
  private static void PrintMenu() {
    System.out.println("=== ГЛАВНОЕ МЕНЮ ===");
    System.out.println("1. Демонстрация линии (Задание 1 (6))");
    System.out.println("2. Демонстрация квадрата (Задание 1 (12))");
    System.out.println("3. Неизменяемый список (Задание 2 (1))");
    System.out.println("4. Трехмерная точка (Задание 3 (5))");
    System.out.println("5. Расширенные точки (Задание 4 (5))");
    System.out.println("6. Суммирование чисел (Задание 5 (1))");
    System.out.println("7. Сравнение линий (Задание 6 (3))");
    System.out.println("8. Клонирование линии (Задание 8 (5))");
    System.out.println("0. Выход");
  }

  /** Демонстрация работы с классом Line. */
  private static void DemonstrateLine() {
    System.out.println("--- Демонстрация линии (Задание 1) ---");
    System.out.println("=== Пример из задания ===");
    Line exampleLine = new Line(2, 3, 8, 7);
    System.out.println("Создана линия: " + exampleLine);
    System.out.println("1. Запрос координат начала и конца:");
    System.out.println("Координаты начала: " + exampleLine.GetStart());
    System.out.println("Координаты конца: " + exampleLine.GetEnd());
    System.out.println("2. Изменение координат начала на (0, 0):");
    exampleLine.SetStart(new Point(0, 0));
    System.out.println("После изменения начала: " + exampleLine);
    System.out.println("3. Изменение координат конца на (10, 5):");
    exampleLine.SetEnd(new Point(10, 5));
    System.out.println("После изменения конца: " + exampleLine);
    System.out.println("4. Длина линии после изменений: " + exampleLine.GetLength());
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте свою линию:");
    double x1 = InputChecker.GetDouble("Начало - X: ");
    double y1 = InputChecker.GetDouble("Начало - Y: ");
    double x2 = InputChecker.GetDouble("Конец - X: ");
    double y2 = InputChecker.GetDouble("Конец - Y: ");
    Line userLine = new Line(x1, y1, x2, y2);
    System.out.println("Создана: " + userLine);
    System.out.println("Длина линии: " + userLine.GetLength());
    DemonstrateLineOperations(userLine);
  }

  /** Меню операций с линией. */
  private static void DemonstrateLineOperations(Line line) {
    while (true) {
      System.out.println("=== Операции с линией ===");
      System.out.println("1. Запросить координаты начала");
      System.out.println("2. Запросить координаты конца");
      System.out.println("3. Изменить координаты начала");
      System.out.println("4. Изменить координаты конца");
      System.out.println("5. Показать длину линии");
      System.out.println("6. Показать полную информацию о линии");
      System.out.println("0. Вернуться в главное меню");
      int choice = InputChecker.GetInt("Выберите операцию: ");
      switch (choice) {
        case 1:
          Point start = line.GetStart();
          System.out.println("Координаты начала линии: " + start);
          break;
        case 2:
          Point end = line.GetEnd();
          System.out.println("Координаты конца линии: " + end);
          break;
        case 3:
          System.out.println("Введите новые координаты начала:");
          double newX = InputChecker.GetDouble("X: ");
          double newY = InputChecker.GetDouble("Y: ");
          Point newStart = new Point(newX, newY);
          line.SetStart(newStart);
          System.out.println("Координаты начала обновлены!");
          System.out.println("Текущая линия: " + line);
          System.out.println("Новая длина: " + line.GetLength());
          break;
        case 4:
          System.out.println("Введите новые координаты конца:");
          double newX2 = InputChecker.GetDouble("X: ");
          double newY2 = InputChecker.GetDouble("Y: ");
          Point newEnd = new Point(newX2, newY2);
          line.SetEnd(newEnd);
          System.out.println("Координаты конца обновлены!");
          System.out.println("Текущая линия: " + line);
          System.out.println("Новая длина: " + line.GetLength());
          break;
        case 5:
          System.out.println("Длина линии: " + line.GetLength());
          break;
        case 6:
          System.out.println("Полная информация о линии:");
          System.out.println("Линия: " + line);
          System.out.println("Начало: " + line.GetStart());
          System.out.println("Конец: " + line.GetEnd());
          System.out.println("Длина: " + line.GetLength());
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
    }
  }

  /** Демонстрация работы с классом Square. */
  private static void DemonstrateSquare() {
    System.out.println("--- Демонстрация квадрата (Задание 1 (12)) ---");
    System.out.println("=== Пример из задания ===");
    Square exampleSquare1 = new Square(5, 3, 23);
    System.out.println("1. Создан через координаты: " + exampleSquare1);
    Point topLeftPoint = new Point(5, 3);
    Square exampleSquare2 = new Square(topLeftPoint, 23);
    System.out.println("2. Создан через точку: " + exampleSquare2);
    Polyline examplePolyline = exampleSquare2.GetPolyline();
    System.out.println("3. Ломаная из квадрата: " + examplePolyline);
    System.out.println("4. Длина ломаной: " + examplePolyline.GetLength());
    System.out.println("5. Изменяем последнюю точку ломаной на {15, 25}");
    java.util.List<Point> examplePoints = examplePolyline.GetPoints();
    if (!examplePoints.isEmpty()) {
      Point lastPoint = examplePoints.get(examplePoints.size() - 1);
      lastPoint.SetX(15);
      lastPoint.SetY(25);
    }
    System.out.println("6. Новая длина ломаной: " + examplePolyline.GetLength());
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите способ создания квадрата:");
    System.out.println("1 - Создать через координаты");
    System.out.println("2 - Создать через объект точки");
    int choice = InputChecker.GetIntInRange("Ваш выбор: ", 1, 2);
    Square userSquare;
    if (choice == 1) {
      System.out.println("Создание квадрата через координаты:");
      double x = InputChecker.GetDouble("Координата X левого верхнего угла: ");
      double y = InputChecker.GetDouble("Координата Y левого верхнего угла: ");
      double side = InputChecker.GetPositiveDouble("Длина стороны: ");
      userSquare = new Square(x, y, side);
    } else {
      System.out.println("Создание квадрата через точку:");
      double x = InputChecker.GetDouble("Координата X левого верхнего угла: ");
      double y = InputChecker.GetDouble("Координата Y левого верхнего угла: ");
      double side = InputChecker.GetPositiveDouble("Длина стороны: ");
      Point userTopLeft = new Point(x, y);
      userSquare = new Square(userTopLeft, side);
    }
    System.out.println("Создан: " + userSquare);
    Polyline userPolyline = userSquare.GetPolyline();
    System.out.println("Ломаная: " + userPolyline);
    System.out.println("Длина ломаной: " + userPolyline.GetLength());
    System.out.println("Хотите изменить последнюю точку ломаной? (да/нет)");
    String answer = InputChecker.GetString();
    if (answer.equalsIgnoreCase("да")) {
      double newX = InputChecker.GetDouble("Новая координата X: ");
      double newY = InputChecker.GetDouble("Новая координата Y: ");
      java.util.List<Point> userPoints = userPolyline.GetPoints();
      if (!userPoints.isEmpty()) {
        Point lastUserPoint = userPoints.get(userPoints.size() - 1);
        lastUserPoint.SetX(newX);
        lastUserPoint.SetY(newY);
        System.out.println("Новая длина ломаной: " + userPolyline.GetLength());
      }
    }
  }

  /** Демонстрация работы с неизменяемым списком ImmutableList. */
  private static void DemonstrateImmutableList() {
    System.out.println("--- Демонстрация неизменяемого списка (Задание 2 (1)) ---");
    System.out.println("=== Пример из задания ===");
    ImmutableList exampleList = new ImmutableList(10, 20, 30, 40, 50);
    System.out.println("Исходный список: " + exampleList);
    ImmutableList modifiedList = exampleList.Set(1, 99);
    System.out.println("После замены элемента [1]=99: " + modifiedList);
    System.out.println("Исходный список не изменился: " + exampleList);
    ImmutableList copiedList = new ImmutableList(exampleList);
    System.out.println("Копия списка: " + copiedList);
    System.out.println("Элемент по индексу 2: " + exampleList.Get(2));
    System.out.println("Размер списка: " + exampleList.Size());
    System.out.println("Список пустой? " + exampleList.IsEmpty());
    int[] array = exampleList.ToArray();
    System.out.println("Массив из ToArray(): " + Arrays.toString(array));
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте свой список (введите числа через пробел):");
    String input = InputChecker.GetString();
    String[] numbers = input.split(" ");
    int[] userValues = new int[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      try {
        userValues[i] = Integer.parseInt(numbers[i]);
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: '" + numbers[i] + "' не является целым числом. Будет заменено на 0.");
        userValues[i] = 0;
      }
    }
    ImmutableList userList = new ImmutableList(userValues);
    System.out.println("Создан список: " + userList);
    while (true) {
      System.out.println("=== Операции с вашим списком ===");
      System.out.println("1. Получить элемент по позиции");
      System.out.println("2. Заменить элемент по позиции (создать новый список)");
      System.out.println("3. Проверить пустоту списка");
      System.out.println("4. Узнать размер списка");
      System.out.println("5. Получить массив значений");
      System.out.println("6. Создать копию списка");
      System.out.println("7. Показать текущий список");
      System.out.println("0. Вернуться в главное меню");
      int operation = InputChecker.GetIntInRange("Выберите операцию: ", 0, 7);
      switch (operation) {
        case 1:
          if (userList.IsEmpty()) {
            System.out.println("Список пуст!");
          } else {
            int index = InputChecker.GetIntInRange("Введите позицию (0-" + (userList.Size() - 1) + "): ",
                0, userList.Size() - 1);
            try {
              int value = userList.Get(index);
              System.out.println("Элемент в позиции " + index + ": " + value);
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Ошибка: " + e.getMessage());
            }
          }
          break;
        case 2:
          if (userList.IsEmpty()) {
            System.out.println("Список пуст!");
          } else {
            int index = InputChecker.GetIntInRange("Введите позицию для замены (0-" + (userList.Size() - 1) + "): ",
                0, userList.Size() - 1);
            int newValue = InputChecker.GetInt("Введите новое значение: ");
            try {
              ImmutableList newList = userList.Set(index, newValue);
              System.out.println("Новый список создан: " + newList);
              System.out.println("Исходный список: " + userList + " (не изменился)");
              System.out.println("Хотите продолжить работу с новым списком? (да/нет)");
              String answer = InputChecker.GetString();
              if (answer.equalsIgnoreCase("да")) {
                userList = newList;
                System.out.println("Теперь работаем с новым списком: " + userList);
              }
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Ошибка: " + e.getMessage());
            }
          }
          break;
        case 3:
          System.out.println("Список пуст? " + userList.IsEmpty());
          break;
        case 4:
          System.out.println("Размер списка: " + userList.Size());
          break;
        case 5:
          int[] arrayCopy = userList.ToArray();
          System.out.println("Массив значений: " + Arrays.toString(arrayCopy));
          break;
        case 6:
          ImmutableList listCopy = new ImmutableList(userList);
          System.out.println("Копия списка создана: " + listCopy);
          System.out.println("Хотите продолжить работу с копией? (да/нет)");
          String copyAnswer = InputChecker.GetString();
          if (copyAnswer.equalsIgnoreCase("да")) {
            userList = listCopy;
            System.out.println("Теперь работаем с копией списка: " + userList);
          }
          break;
        case 7:
          System.out.println("Текущий список: " + userList);
          System.out.println("Строковое представление: " + userList.toString());
          System.out.println("Размер: " + userList.Size());
          System.out.println("Пуст? " + userList.IsEmpty());
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
    }
  }

  /** Демонстрация трёхмерной точки Point3D. */
  private static void DemonstratePoint3D() {
    System.out.println("--- Демонстрация трехмерной точки (Задание 3 (5)) ---");
    System.out.println("=== Пример из задания ===");
    Point3D example3D = new Point3D(1, 2, 3);
    System.out.println("Трехмерная точка: " + example3D);
    Point basePoint = example3D;
    System.out.println("Как обычная точка (только X, Y): " + basePoint);
    example3D.SetZ(10);
    System.out.println("После изменения Z на 10: " + example3D);
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    double x = InputChecker.GetDouble("Введите координату X: ");
    double y = InputChecker.GetDouble("Введите координату Y: ");
    double z = InputChecker.GetDouble("Введите координату Z: ");
    Point3D userPoint3D = new Point3D(x, y, z);
    System.out.println("Создана: " + userPoint3D);
    double newZ = InputChecker.GetDouble("Введите новое значение Z: ");
    userPoint3D.SetZ(newZ);
    System.out.println("После изменения Z: " + userPoint3D);
  }

  /** Демонстрация расширенных точек (ColoredPoint, TimedPoint). */
  private static void DemonstrateExtendedPoints() {
    System.out.println("--- Демонстрация расширенных точек (Задание 4) ---");
    System.out.println("=== Пример из задания ===");
    ColoredPoint coloredExample = new ColoredPoint(3, 5, "красный");
    TimedPoint timedExample = new TimedPoint(4, 2, "12:30");
    ColoredPoint complexExample = new ColoredPoint(7, 7, "желтый");
    System.out.println("Пример 1 - " + coloredExample);
    System.out.println("Пример 2 - " + timedExample);
    System.out.println("Пример 3 - " + complexExample);
    AbstractPoint[] examplePoints = {coloredExample, timedExample, complexExample};
    System.out.println("Массив абстрактных точек (полиморфизм):");
    for (AbstractPoint point : examplePoints) {
      System.out.println("  - " + point);
    }
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте цветную точку:");
    double x1 = InputChecker.GetDouble("Координата X: ");
    double y1 = InputChecker.GetDouble("Координата Y: ");
    String color = InputChecker.GetNonEmptyString("Цвет: ");
    ColoredPoint userColored = new ColoredPoint(x1, y1, color);
    System.out.println("Создайте точку со временем:");
    double x2 = InputChecker.GetDouble("Координата X: ");
    double y2 = InputChecker.GetDouble("Координата Y: ");
    String time = InputChecker.GetNonEmptyString("Время: ");
    TimedPoint userTimed = new TimedPoint(x2, y2, time);
    System.out.println("Результат:");
    System.out.println("Цветная точка: " + userColored);
    System.out.println("Точка со временем: " + userTimed);
  }

  /** Демонстрация суммирования чисел через SumCalculator. */
  private static void DemonstrateSum() {
    System.out.println("--- Демонстрация суммирования чисел (Задание 5 (1)) ---");
    double result1 = SumCalculator.Sum(2, 3.0 / 5, 2.3);
    double result2 = SumCalculator.Sum(3.6, 49.0 / 12, 3, 3.0 / 2);
    double result3 = SumCalculator.Sum(1.0 / 3, 1);
    System.out.println("2 + 3/5 + 2.3 = " + result1);
    System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);
    System.out.println("1/3 + 1 = " + result3);
    System.out.println("Демонстрация с пользовательским вводом:");
    double num1 = InputChecker.GetDouble("Введите первое число: ");
    double num2 = InputChecker.GetDouble("Введите второе число: ");
    double num3 = InputChecker.GetDouble("Введите третье число: ");
    double customSum = SumCalculator.Sum(num1, num2, num3);
    System.out.println("Сумма: " + customSum);
  }

  /** Демонстрация сравнения линий через equals. */
  private static void DemonstrateLineComparison() {
    System.out.println("--- Демонстрация сравнения линий (Задание 6 (3)) ---");
    System.out.println("=== Пример из задания ===");
    Line lineA = new Line(0, 0, 5, 5);
    Line lineB = new Line(0, 0, 5, 5);
    Line lineC = new Line(1, 1, 10, 10);
    Line lineD = new Line(5, 5, 0, 0);
    System.out.println("Линия A: " + lineA);
    System.out.println("Линия B: " + lineB);
    System.out.println("Линия C: " + lineC);
    System.out.println("Линия D: " + lineD);
    System.out.println("A.equals(B): " + lineA.equals(lineB) + " (ожидается true)");
    System.out.println("A.equals(C): " + lineA.equals(lineC) + " (ожидается false)");
    System.out.println("A.equals(D): " + lineA.equals(lineD) + " (ожидается false)");
    System.out.println("A == B: " + (lineA == lineB) + " (ожидается false - разные объекты)");
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте две линии для сравнения:");
    System.out.println("Первая линия:");
    double x1 = InputChecker.GetDouble("x1: ");
    double y1 = InputChecker.GetDouble("y1: ");
    double x2 = InputChecker.GetDouble("x2: ");
    double y2 = InputChecker.GetDouble("y2: ");
    Line userLine1 = new Line(x1, y1, x2, y2);
    System.out.println("Вторая линия:");
    double x3 = InputChecker.GetDouble("x1: ");
    double y3 = InputChecker.GetDouble("y1: ");
    double x4 = InputChecker.GetDouble("x2: ");
    double y4 = InputChecker.GetDouble("y2: ");
    Line userLine2 = new Line(x3, y3, x4, y4);
    System.out.println("Линия 1: " + userLine1);
    System.out.println("Линия 2: " + userLine2);
    System.out.println("Линии равны? " + userLine1.equals(userLine2));
  }

  /** Демонстрация клонирования линии. */
  private static void DemonstrateLineClone() {
    System.out.println("--- Демонстрация клонирования линии (Задание 8 (5)) ---");
    System.out.println("=== Пример из задания ===");
    Line originalExample = new Line(2, 2, 8, 8);
    Line clonedExample = originalExample.clone();
    System.out.println("Оригинал: " + originalExample);
    System.out.println("Клон: " + clonedExample);
    System.out.println("Оригинал.equals(Клон): " + originalExample.equals(clonedExample));
    System.out.println("Оригинал == Клон: " + (originalExample == clonedExample));
    System.out.println("Изменяем начальную точку клона на (10, 10):");
    clonedExample.SetStart(new Point(10, 10));
    System.out.println("После изменения:");
    System.out.println("Оригинал: " + originalExample + " (не изменился)");
    System.out.println("Клон: " + clonedExample + " (изменился)");
    System.out.println("Теперь линии равны? " + originalExample.equals(clonedExample));
    System.out.println();
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте линию для клонирования:");
    double x1 = InputChecker.GetDouble("x1: ");
    double y1 = InputChecker.GetDouble("y1: ");
    double x2 = InputChecker.GetDouble("x2: ");
    double y2 = InputChecker.GetDouble("y2: ");
    Line original = new Line(x1, y1, x2, y2);
    Line cloned = original.clone();
    System.out.println("Оригинал: " + original);
    System.out.println("Клон: " + cloned);
    System.out.println("Оригинал и клон равны? " + original.equals(cloned));
    System.out.println("Это один и тот же объект? " + (original == cloned));
    System.out.println("Хотите изменить клон? (да/нет)");
    String answer = InputChecker.GetString();
    if (answer.equalsIgnoreCase("да")) {
      double newX = InputChecker.GetDouble("Новая координата X начала: ");
      double newY = InputChecker.GetDouble("Новая координата Y начала: ");
      cloned.SetStart(new Point(newX, newY));
      System.out.println("После изменения клона:");
      System.out.println("Оригинал: " + original);
      System.out.println("Клон: " + cloned);
      System.out.println("Теперь линии равны? " + original.equals(cloned));
    }
  }

  /**
   * Точка входа в программу.
   * @param args аргументы командной строки (ожидается два: основание и показатель степени)
   */
  public static void main(String[] args) {
    if (args.length == 2)
      HandleCommandLineArgs(args);
    RunInteractiveMenu();
  }
}