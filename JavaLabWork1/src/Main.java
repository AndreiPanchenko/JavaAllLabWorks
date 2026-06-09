import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int mainChoice;
    Methods methods = new Methods();

    do {
      // === ГЛАВНОЕ МЕНЮ ===
      System.out.println("=== ГЛАВНОЕ МЕНЮ ===");
      System.out.println("1. Методы");
      System.out.println("2. Условия");
      System.out.println("3. Циклы");
      System.out.println("4. Массивы");
      System.out.println("0. Выход");
      System.out.print("Выберите категорию: ");

      // Обработка некорректного ввода
      while (!scanner.hasNextInt()) {
        System.out.println("Ошибка! Введите число от 0 до 4.");
        scanner.next();
      }
      mainChoice = scanner.nextInt();

      // Навигация по разделам
      switch (mainChoice) {
        case 1:
          methodsMenu(scanner, methods);
          break;
        case 2:
          conditionsMenu(scanner, methods);
          break;
        case 3:
          loopsMenu(scanner, methods);
          break;
        case 4:
          arraysMenu(scanner, methods);
          break;
        case 0:
          System.out.println("Выход из программы...");
          break;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    } while (mainChoice != 0);

    scanner.close();
  }

  // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ДЛЯ ПРОВЕРКИ ВВОДА ==========

  private static int readInt(Scanner scanner, String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextInt()) {
      System.out.println("Ошибка! Введите целое число.");
      scanner.next();
      System.out.print(prompt);
    }
    return scanner.nextInt();
  }

  private static double readDouble(Scanner scanner, String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextDouble()) {
      System.out.println("Ошибка! Введите число.");
      scanner.next();
      System.out.print(prompt);
    }
    return scanner.nextDouble();
  }

  private static long readLong(Scanner scanner, String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextLong()) {
      System.out.println("Ошибка! Введите целое число.");
      scanner.next();
      System.out.print(prompt);
    }
    return scanner.nextLong();
  }

  private static char readChar(Scanner scanner, String prompt) {
    System.out.print(prompt);
    String input = scanner.next();
    while (input.length() != 1 || !Character.isDigit(input.charAt(0))) {
      System.out.println("Ошибка! Введите одну цифру.");
      System.out.print(prompt);
      input = scanner.next();
    }
    return input.charAt(0);
  }

  // ========== РАЗДЕЛ МЕТОДОВ ==========
  private static void methodsMenu(Scanner scanner, Methods methods) {
    int choice;
    do {
      System.out.println("=== МЕТОДЫ ===");
      System.out.println("1. Дробная часть");
      System.out.println("2. Букву в число");
      System.out.println("3. Двузначное");
      System.out.println("4. Диапазон");
      System.out.println("5. Равенство");
      System.out.println("0. Назад в главное меню");
      choice = readInt(scanner, "Выберите задачу: ");

      switch (choice) {
        case 1:
          double num = readDouble(scanner, "Введите число: ");
          System.out.println("Дробная часть: " + methods.fraction(num));
          break;
        case 2:
          char digit = readChar(scanner, "Введите цифру: ");
          System.out.println("Число: " + methods.charToNum(digit));
          break;
        case 3:
          int num2 = readInt(scanner, "Введите число: ");
          System.out.println("Результат: " + methods.is2Digits(num2));
          break;
        case 4:
          int a = readInt(scanner, "Введите границу a: ");
          int b = readInt(scanner, "Введите границу b: ");
          int num3 = readInt(scanner, "Введите число num: ");
          System.out.println("Результат: " + methods.isInRange(a, b, num3));
          break;
        case 5:
          int a2 = readInt(scanner, "Введите a: ");
          int b2 = readInt(scanner, "Введите b: ");
          int c = readInt(scanner, "Введите c: ");
          System.out.println("Результат: " + methods.isEqual(a2, b2, c));
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          break;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    } while (choice != 0);
  }

  // ========== РАЗДЕЛ УСЛОВИЙ ==========
  private static void conditionsMenu(Scanner scanner, Methods methods) {
    int choice;
    do {
      System.out.println("=== УСЛОВИЯ ===");
      System.out.println("1. Модуль числа");
      System.out.println("2. Тридцать пять");
      System.out.println("3. Тройной максимум");
      System.out.println("4. Двойная сумма");
      System.out.println("5. День недели");
      System.out.println("0. Назад в главное меню");
      choice = readInt(scanner, "Выберите задачу: ");

      switch (choice) {
        case 1:
          int num = readInt(scanner, "Введите число: ");
          System.out.println("Модуль: " + methods.abs(num));
          break;
        case 2:
          int num2 = readInt(scanner, "Введите число: ");
          System.out.println("Результат: " + methods.is35(num2));
          break;
        case 3:
          int x = readInt(scanner, "Введите x: ");
          int y = readInt(scanner, "Введите y: ");
          int z = readInt(scanner, "Введите z: ");
          System.out.println("Максимум: " + methods.max3(x, y, z));
          break;
        case 4:
          int x2 = readInt(scanner, "Введите x: ");
          int y2 = readInt(scanner, "Введите y: ");
          System.out.println("Сумма: " + methods.sum2(x2, y2));
          break;
        case 5:
          int dayNum = readInt(scanner, "Введите день недели (1-7): ");
          while (dayNum < 1 || dayNum > 7) {
            System.out.println("Ошибка! День недели должен быть от 1 до 7.");
            dayNum = readInt(scanner, "Введите день недели (1-7): ");
          }
          System.out.println("День: " + methods.day(dayNum));
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          break;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    } while (choice != 0);
  }

  // ========== РАЗДЕЛ ЦИКЛОВ ==========
  private static void loopsMenu(Scanner scanner, Methods methods) {
    int choice;
    do {
      System.out.println("=== ЦИКЛЫ ===");
      System.out.println("1. Числа подряд");
      System.out.println("2. Четные числа");
      System.out.println("3. Длина числа");
      System.out.println("4. Квадрат");
      System.out.println("5. Правый треугольник");
      System.out.println("0. Назад в главное меню");
      choice = readInt(scanner, "Выберите задачу: ");

      switch (choice) {
        case 1:
          int x = readInt(scanner, "Введите x: ");
          while (x < 0) {
            System.out.println("Ошибка! Число должно быть неотрицательным.");
            x = readInt(scanner, "Введите x: ");
          }
          System.out.println("Результат: " + methods.listNums(x));
          break;
        case 2:
          int x2 = readInt(scanner, "Введите x: ");
          while (x2 < 0) {
            System.out.println("Ошибка! Число должно быть неотрицательным.");
            x2 = readInt(scanner, "Введите x: ");
          }
          System.out.println("Результат: " + methods.chet(x2));
          break;
        case 3:
          long num = readLong(scanner, "Введите число: ");
          System.out.println("Длина: " + methods.numLen(num));
          break;
        case 4:
          int size = readInt(scanner, "Введите размер: ");
          while (size < 0) {
            System.out.println("Ошибка! Размер не может быть отрицательным.");
            size = readInt(scanner, "Введите размер: ");
          }
          methods.square(size);
          break;
        case 5:
          int height = readInt(scanner, "Введите высоту: ");
          while (height < 0) {
            System.out.println("Ошибка! Высота не может быть отрицательной.");
            height = readInt(scanner, "Введите высоту: ");
          }
          methods.rightTriangle(height);
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          break;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    } while (choice != 0);
  }

  // ========== РАЗДЕЛ МАССИВОВ ==========
  private static void arraysMenu(Scanner scanner, Methods methods) {
    int choice;
    do {
      System.out.println("=== МАССИВЫ ===");
      System.out.println("1. Поиск первого значения");
      System.out.println("2. Поиск максимального");
      System.out.println("3. Добавление массива в массив");
      System.out.println("4. Возвратный реверс");
      System.out.println("5. Все вхождения");
      System.out.println("0. Назад в главное меню");
      choice = readInt(scanner, "Выберите задачу: ");

      switch (choice) {
        case 1:
          System.out.println("Введите массив (через пробел):");
          scanner.nextLine();
          int[] arr = methods.parseArray(scanner.nextLine());
          if (arr.length == 0) {
            System.out.println("Ошибка: массив не может быть пустым!");
            break;
          }
          int target = readInt(scanner, "Введите искомый элемент: ");
          System.out.println("Индекс: " + methods.findFirst(arr, target));
          break;
        case 2:
          System.out.println("Введите массив (через пробел):");
          scanner.nextLine();
          int[] arr2 = methods.parseArray(scanner.nextLine());
          if (arr2.length == 0) {
            System.out.println("Ошибка: массив не может быть пустым!");
            break;
          }
          System.out.println("Макс. по модулю: " + methods.maxAbs(arr2));
          break;
        case 3:
          System.out.println("Введите основной массив (через пробел):");
          scanner.nextLine();
          int[] mainArr = methods.parseArray(scanner.nextLine());
          System.out.println("Введите массив для вставки (через пробел):");
          int[] insArr = methods.parseArray(scanner.nextLine());
          if (mainArr.length == 0 && insArr.length == 0) {
            System.out.println("Ошибка: оба массива не могут быть пустыми!");
            break;
          }
          int pos = readInt(scanner, "Введите позицию: ");
          if (pos < 0 || pos > mainArr.length) {
            System.out.println("Ошибка: позиция должна быть в диапазоне от 0 до " + mainArr.length);
            break;
          }
          System.out.println("Результат: " + Arrays.toString(methods.add(mainArr, insArr, pos)));
          break;
        case 4:
          System.out.println("Введите массив (через пробел):");
          scanner.nextLine();
          int[] arr3 = methods.parseArray(scanner.nextLine());
          if (arr3.length == 0) {
            System.out.println("Ошибка: массив не может быть пустым!");
            break;
          }
          System.out.println("Перевёрнутый: " + Arrays.toString(methods.reverseBack(arr3)));
          break;
        case 5:
          System.out.println("Введите массив (через пробел):");
          scanner.nextLine();
          int[] arr4 = methods.parseArray(scanner.nextLine());
          if (arr4.length == 0) {
            System.out.println("Ошибка: массив не может быть пустым!");
            break;
          }
          int target2 = readInt(scanner, "Введите искомый элемент: ");
          System.out.println("Индексы: " + Arrays.toString(methods.findAll(arr4, target2)));
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          break;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
      }
    } while (choice != 0);
  }
}
