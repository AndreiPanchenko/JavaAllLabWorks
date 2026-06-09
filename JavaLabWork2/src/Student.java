// Класс, представляющий студента
// Хранит имя и массив оценок
public class Student {
  private String name;
  private int[] grades;

  // Конструктор студента с именем(name) и массивом оценок(grades)

  public Student(String name, int[] grades) {
    this.name = name;
    // Создаём копию массива, чтобы избежать изменений извне
    this.grades = grades.clone();
  }

  // Геттеры
  public String getName() {
    return name;
  }

  public int[] getGrades() {
    // Возвращаем копию массива, чтобы его нельзя было изменить извне
    return grades.clone();
  }

  // Возвращает строковое представление студента в формате:
  // "Имя: [оценка1, оценка2, ...]"

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(": [");
    for (int i = 0; i < grades.length; i++) {
      sb.append(grades[i]);
      if (i < grades.length - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }
}