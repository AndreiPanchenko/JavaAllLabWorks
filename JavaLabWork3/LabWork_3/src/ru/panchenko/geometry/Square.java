package ru.panchenko.geometry;

/**
 * Класс квадрата, заданного левой верхней точкой и длиной стороны.
 */
public class Square {

  private Point topLeft;
  private double side;

  /**
   * Конструктор квадрата по объекту точки.
   * @param topLeft левая верхняя точка (не может быть null)
   * @param side длина стороны (положительное число)
   * @throws IllegalArgumentException если topLeft null или side ≤ 0
   */
  public Square(Point topLeft, double side) {
    if (topLeft == null)
      throw new IllegalArgumentException("Верхняя левая точка не может быть null");
    if (side <= 0)
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    this.topLeft = new Point(topLeft.GetX(), topLeft.GetY());
    this.side = side;
  }

  /**
   * Конструктор квадрата по координатам левой верхней точки.
   * @param x координата X левой верхней точки
   * @param y координата Y левой верхней точки
   * @param side длина стороны (положительное число)
   * @throws IllegalArgumentException если side ≤ 0
   */
  public Square(double x, double y, double side) {
    if (side <= 0)
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    this.topLeft = new Point(x, y);
    this.side = side;
  }

  /**
   * Возвращает ломаную, представляющую контур квадрата (замкнутый).
   * @return новая ломаная из пяти точек (последняя совпадает с первой)
   */
  public Polyline GetPolyline() {
    Point p1 = new Point(topLeft.GetX(), topLeft.GetY());
    Point p2 = new Point(topLeft.GetX() + side, topLeft.GetY());
    Point p3 = new Point(topLeft.GetX() + side, topLeft.GetY() + side);
    Point p4 = new Point(topLeft.GetX(), topLeft.GetY() + side);
    return new Polyline(p1, p2, p3, p4, p1);
  }

  /**
   * Возвращает копию левой верхней точки квадрата.
   * @return новая точка
   */
  public Point GetTopLeft() {
    return new Point(topLeft.GetX(), topLeft.GetY());
  }

  /**
   * Возвращает длину стороны квадрата.
   * @return сторона
   */
  public double GetSide() {
    return side;
  }

  /**
   * Устанавливает новую левую верхнюю точку.
   * @param topLeft новая точка (не может быть null)
   * @throws IllegalArgumentException если topLeft null
   */
  public void SetTopLeft(Point topLeft) {
    if (topLeft == null)
      throw new IllegalArgumentException("Верхняя левая точка не может быть null");
    this.topLeft = new Point(topLeft.GetX(), topLeft.GetY());
  }

  /**
   * Устанавливает новую длину стороны.
   * @param side новая сторона (положительное число)
   * @throws IllegalArgumentException если side ≤ 0
   */
  public void SetSide(double side) {
    if (side <= 0)
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    this.side = side;
  }

  /**
   * Возвращает строковое представление квадрата.
   * @return строка вида "Квадрат в точке {x;y} со стороной side"
   */
  @Override
  public String toString() {
    return "Квадрат в точке " + topLeft + " со стороной " + side;
  }
}