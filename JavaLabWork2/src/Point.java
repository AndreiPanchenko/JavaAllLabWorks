// Класс, представляющий точку на двумерной плоскости
// Содержит координаты X и Y

public class Point {
  // Приватные поля для хранения координат точки
  private double x;
  private double y;

  // Конструктор точки с заданными координатами

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // Геттеры и сеттеры
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  // Возвращает строковое представление точки в формате {X;Y}
  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }
}
