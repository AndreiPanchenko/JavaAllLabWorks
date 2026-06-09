import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      System.out.println("=== Меню заданий ===");
      System.out.println("1. Задание 1 - Точка координат");
      System.out.println("2. Задание 2 - Прямая");
      System.out.println("3. Задание 3 - Студент");
      System.out.println("4. Задание 4 - Создаем Точку и Линию");
      System.out.println("5. Задание 5 - Пистолет стреляет");
      System.out.println("0. Выход");
      System.out.print("Выберите задание: ");

      int choice = TaskManager.readInt(scanner);

      switch (choice) {
        case 1:
          TaskManager.task1(scanner);
          break;
        case 2:
          TaskManager.task2();
          break;
        case 3:
          TaskManager.task3();
          break;
        case 4:
          TaskManager.task4();
          break;
        case 5:
          TaskManager.task5();
          break;
        case 0:
          exit = true;
          System.out.println("Выход из программы.");
          break;
        default:
          System.out.println("Неверный выбор. Попробуйте снова.");
      }
    }
    scanner.close();
  }
}
